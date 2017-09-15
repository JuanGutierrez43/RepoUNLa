package Model;

import java.util.ArrayList;
import java.util.List;
import Model.Proceso.Prioridad;
import Model.Tabla;

public class admProcesamiento {

	private List<Proceso> lstProcesos;
	private int cantidadFilas;
	private int cantidaColumnas;
	private Tabla[][] tabla;
	private Hilo hilo;
	private Buffers buffers;
	private Listo listo;

	public admProcesamiento(int cantidadFilas, int cantidaColumnas) {
		this.lstProcesos = new ArrayList<Proceso>();
		this.cantidadFilas = cantidadFilas;
		this.cantidaColumnas = cantidaColumnas;
		this.tabla = new Tabla[cantidadFilas][cantidaColumnas];
		setTabla();
		this.hilo = new Hilo(1);
		this.buffers = new Buffers(1);
		this.listo = new Listo(1);
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	public Tabla[][] getTabla() {
		return tabla;
	}

	public void setTabla(Tabla[][] tabla) {
		this.tabla = tabla;
	}

	public void setTabla() {
		for (int i = 0; i < getCantidadFilas(); i++) {
			for (int j = 0; j < getCantidaColumnas(); j++) {
				this.tabla[i][j] = new Tabla(i + 1, j + 1);
			}
		}
	}

	public void setTabla(Tabla[][] tablaA, Tabla[][] tablaB) {
		for (int i = 0; i < getCantidadFilas(); i++) {
			for (int j = 0; j < getCantidaColumnas(); j++) {
				tablaA[i][j] = new Tabla(i + 1, j + 1);
			}
		}
	}

	public int getCantidadFilas() {
		return cantidadFilas;
	}

	public void setCantidadFilas(int cantidadFilas) {
		this.cantidadFilas = cantidadFilas;
	}

	public int getCantidaColumnas() {
		return cantidaColumnas;
	}

	public void setCantidaColumnas(int cantidaColumnas) {
		this.cantidaColumnas = cantidaColumnas;
	}

	public Hilo getHilo() {
		return hilo;
	}

	public void setHilo(Hilo hilo) {
		this.hilo = hilo;
	}

	public Buffers getBuffers() {
		return buffers;
	}

	public void setBuffers(Buffers buffers) {
		this.buffers = buffers;
	}

	public Listo getListo() {
		return listo;
	}

	public void setListo(Listo listo) {
		this.listo = listo;
	}
	/*------------------------------------------------------*/
	// Metodos
	/*------------------------------------------------------*/

	// Creado
	public boolean agregarProceso(String proceso, int comienzaTiempo, int iCPU, int eyS, int fCPU,
			Prioridad prioridad) {
		boolean agregar = false;
		int idProceso = 1;
		if (!getLstProcesos().isEmpty()) {
			idProceso = getLstProcesos().get(getLstProcesos().size() - 1).getIdProceso() + 1;
		}
		Duracion duracion = new Duracion(iCPU, eyS, fCPU);
		agregar = getLstProcesos().add(new Proceso(idProceso, proceso, comienzaTiempo, prioridad, duracion));
		return agregar;
	}

	// Traer Proceso
	public Proceso traerProceso(int index) {
		Proceso procesoAux = null;
		if (!getLstProcesos().isEmpty() && getLstProcesos().size() > index) {
			procesoAux = getLstProcesos().get(index);
		}
		return procesoAux;
	}

	// Ejecutar
	public boolean ejecutarProceso(Proceso proceso) {
		boolean validate = false;
		validate = getHilo().ejecutarProceso(proceso); // mejoras
		return validate;
	}

	public Proceso terminarProceso() {
		Proceso procesoAux = new Proceso();
		if (getHilo().isEjecutando()) {
			procesoAux = getHilo().eliminarProceso();
		}
		return procesoAux;
	}

	// Bloquear
	public boolean bloquearProceso(Proceso proceso) {
		boolean validate = false;
		validate = getBuffers().bloquearProceso(proceso);
		return validate;
	}

	public Proceso desbloquearProceso(int idProceso) {
		Proceso procesoAux = new Proceso();
		if (!getBuffers().getLstProcesos().isEmpty()) {
			procesoAux = getBuffers().eliminarBloqueado(idProceso);
		}
		return procesoAux;
	}

	// listar para FIFO
	public boolean listarProcesoFIFO(Proceso proceso) {
		boolean validate = false;
		// agrego al final
		validate = getListo().getLstProcesos().add(proceso);
		return validate;
	}

	public Proceso deslistarProcesoFIFO() {
		Proceso procesoAux = null;
		// sale el primero
		if (!getListo().getLstProcesos().isEmpty()) {
			// procesoAux = getListo().deslistarProceso(1);
			// no porque no saco por id sino por index
			procesoAux = getListo().getLstProcesos().get(0); // mejoras
			getListo().getLstProcesos().remove(0);
		}
		return procesoAux;
	}

	// listar para Prioridades...
	/*------------------------------------------------------*/

	public String mostrarLstProceso() {
		String string = "";
		for (Proceso proceso : getLstProcesos()) {
			string += proceso + "\n";
		}
		return string;
	}

	public String mostrarAlgoritmoPrioridad() {
		List<Proceso> lstProcesosListo = new ArrayList<Proceso>();
		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		String string = "";
		/*-------------- Respaldo Datos Originales ------------*/
		// clono la lista original a lstProcesosListo (revisado)
		for (Proceso proceso : getLstProcesos()) { // inicializo Lista nueva
			Proceso auxProceso1 = new Proceso(proceso.getIdProceso(), proceso.getProceso(), proceso.getComienzaTiempo(),
					proceso.getPrioridad(), new Duracion(proceso.getDuracion().getiCPU(),
							proceso.getDuracion().getEyS(), proceso.getDuracion().getfCPU()));
			lstProcesosListo.add(auxProceso1);
		}
		setTabla(auxTabla, getTabla()); // inicializar tabla nueva

		/*-------------- traer Algoritmo Prioridad ------------*/
		string += "Algoritmo Prioridad";
		string += "\n" + toString(planificarPrioridad(lstProcesosListo, auxTabla));
		string += "\n" + mostrarLstProceso();
		string += "\n-> hay 1 procesador";
		string += "\n-> E/S Se realiza en paralelo";	
		return string;
	}

	private Tabla[][] planificarPrioridad(List<Proceso> procesos, Tabla[][] auxTabla) {
		/*-------------- Inicio Planificar Prioridad------------*/
		// preparo el hilo
		getHilo().setEjecutando(false);
		boolean avilitarEyS = true;
		boolean bloquear = true;
		int cont = procesos.size();
		// contador -- para cargar estado
		// Carga a la matriz los estados E y B
		/*-------------- primera pasada ------------*/
		if (!procesos.isEmpty()) {
			/* por toda la tabla agrego los estados */
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				avilitarEyS = true;
				bloquear = true;
				for (int fila = 0; fila < procesos.size(); fila++) {
					/* listar procesos a la lstProcesos */
					if (cont >= 0) {
						if (procesos.get(fila).getComienzaTiempo() == (columna + 1)) {
							cont--;
							// guardo proceso a listo
							listarProcesoFIFO(procesos.get(fila));
							// ordeno por prioridad lista de Listos
							getListo().ordenarPrioridad();
						}
					}
				} // Procesos por fila

				/* reviso si CPU esta libre para agregar un proceso nuevo */
				if (!getHilo().isEjecutando()) {
					// sacar un proceso de listo y lo pasar al CPU
					if (!getListo().getLstProcesos().isEmpty()) {
						ejecutarProceso(deslistarProcesoFIFO());
						// miestras que la columna anterior no tenga estado bloqueado, entonces (me soluciono todo) :) Revisar a futuro porque me daba error
						if (columna > 0 && !auxTabla[getHilo().getProceso().getIdProceso() - 1][columna - 1].equals("B")) {
							// deshabilitar ejecución de entrada y salido 1 vez por paralelismo
							avilitarEyS = false;
							columna--;
						}
					}
				}

				/* reviso CPU y ejecuto proceso */
				if (getHilo().isEjecutando()) {
					boolean ejecutando = getHilo().ejecutarInstrucción();
					// cargo a la tabla estado E caso 1
					if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() >= 0) {
						auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
					}
					// cargo a la tabla estado E caso 2
					if (ejecutando && getHilo().getProceso().getDuracion().getfCPU() >= 0) {
						auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
					}
					// paso el proceso a bloqueado o lo Termino
					if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1
							&& getHilo().getProceso().getDuracion().getfCPU() == -1) {
						auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("T");
						terminarProceso(); // elimino el Proceso
						bloquear = false; // aviso que no bloquee
					}
					if (bloquear) {// no tira error de hilo vacio cuidado con esta parte que puede ser causa errores por la id que traigo que es distinto que el index :) Revisar a futuro porque me daba error
						if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1 && getHilo().getProceso().getDuracion().getfCPU() == traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getfCPU()) {
							bloquearProceso(terminarProceso());
						}
					}
				}

				/* Las E/S se realiza en paralelo */
				if (!getBuffers().getLstProcesos().isEmpty() && avilitarEyS) {
					for (Proceso proceso : getBuffers().getLstProcesos()) {
						if (proceso.getDuracion().getEyS() > 0) {
							getBuffers().ejecutarEyS(proceso.getIdProceso());
							auxTabla[proceso.getIdProceso() - 1][columna].setEstado("B");
						}
					}
				}

				// Paso de proceso Bloqueado a listo
				if (avilitarEyS) {
					int i = 0;
					int reiniciar = getBuffers().getLstProcesos().size();
					int lenD = getBuffers().getLstProcesos().size();
					while (reiniciar > 0) {
						i = 0;
						while (i < lenD) {
							if (getBuffers().getLstProcesos().get(i).getDuracion().getEyS() <= 0) {
								// System.out.println(getBuffers()+" "+columna);
								listarProcesoFIFO(
										desbloquearProceso(getBuffers().getLstProcesos().get(i).getIdProceso()));
								getListo().ordenarPrioridad();
								// como saque un Proceso, entonces
								lenD--;
								i = getBuffers().getLstProcesos().size();
							}
							i++;
						}
						reiniciar--;
					}
				}

				/****test de prueba****/
				 int test=8;
				 if (columna == (test-1)) {
				 System.out.println("\n" + getListo() + " " + (columna + 1));
				 System.out.println(getHilo());
				 System.out.println(getBuffers());
				 }

			} // Fin del tiempo de la tabla
		}
		return auxTabla;
	}

	public String mostrarAlgoritmoFIFO() {

		List<Proceso> lstProcesosListo = new ArrayList<Proceso>();
		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		String string = "";
		/*-------------- Respaldo Datos Originales ------------*/
		// clono la lista original a lstProcesosListo (revisado)
		for (Proceso proceso : getLstProcesos()) { // inicializo Lista nueva
			Proceso auxProceso1 = new Proceso(proceso.getIdProceso(), proceso.getProceso(), proceso.getComienzaTiempo(),
					proceso.getPrioridad(), new Duracion(proceso.getDuracion().getiCPU(),
							proceso.getDuracion().getEyS(), proceso.getDuracion().getfCPU()));
			lstProcesosListo.add(auxProceso1);
		}
		setTabla(auxTabla, getTabla()); // inicializar tabla nueva
		/*-------------- Recupero Datos Originales ------------*/
		// no es necesario
		/*-------------- traer Algoritmo FIFO ------------*/
		string += "Algoritmo FIFO";
		string += "\n" + toString(planificarFIFO(lstProcesosListo, auxTabla));
		string += "\n" + mostrarLstProceso();
		string += "\n-> hay 1 procesador";
		string += "\n-> E/S Se realiza en paralelo";

		return string;
	}

	public Tabla[][] planificarFIFO(List<Proceso> lstProcesosListo, Tabla[][] auxTabla) {
		List<Proceso> lstProcesosListo2 = new ArrayList<Proceso>();
		int finale = 0;
		/*-------------- Inicio FIFO------------*/
		// preparo el hilo
		getHilo().setEjecutando(false);
		// inicializo Estado listo
		// Carga a la matriz los estados E y B
		/*-------------- primera pasada ------------*/
		if (!lstProcesosListo.isEmpty()) {
			/* por toda la tabla agrego los estados */
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {

				for (int fila = 0; fila < lstProcesosListo.size(); fila++) {
					/* listar procesos a la lstProcesos */
					if (lstProcesosListo.get(fila).getComienzaTiempo() == columna + 1) {
						// guardo proceso a listo
						listarProcesoFIFO(lstProcesosListo.get(fila));
					}
					/* reviso si CPU esta libre para proceso nuevo */
					if (!getHilo().isEjecutando()) {
						// saco un proceso de listo y lo paso al CPU
						if (!getListo().getLstProcesos().isEmpty()) {
							ejecutarProceso(deslistarProcesoFIFO());
						}
					}
					/* reviso si CPU esta en uso y cual proceso ejecuta */
					if (getHilo().isEjecutando() && getHilo().getProceso().equal(fila + 1)) {
						boolean ejecutando = getHilo().ejecutarInstrucción();
						if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() >= 0) {
							// System.out.println("\t"+getHilo());// Compruebo
							auxTabla[fila][columna].setEstado("E");
							/* si un proceso completo el uso de CPU entonces */
						} else {
							if (getHilo().getProceso().getDuracion().getiCPU() < 0) {
								// información donde se bloquea
								// System.out.println(fila+" "+columna);
								if (getHilo().getProceso().getDuracion().getiCPU() == -1) {
									bloquearProceso(terminarProceso());
									// me guardo posicion final para 2da pasada
									finale = columna + 1;
								}
							}
						}
					}
					/* Las E/S se realiza en paralelo */
					if (!getBuffers().getLstProcesos().isEmpty()) {
						boolean eliminar = false;
						for (Proceso proceso : getBuffers().getLstProcesos()) {
							if (proceso.equal(fila + 1)) {
								if (getBuffers().traerProceso(fila + 1).getDuracion().getEyS() > 0) {
									getBuffers().ejecutarEyS(fila + 1);
									auxTabla[fila][columna].setEstado("B");
								} else {
									eliminar = true;
								}
							}
						}
						if (eliminar) {
							// Copio a otra 2da lista
							lstProcesosListo2.add(desbloquearProceso(fila + 1));
							for (Proceso proceso : lstProcesosListo2) {
								if (proceso.equal(fila + 1)) {
									// busco el proceso por su id para no tener
									// errores y seteo su tiempo de comienzo
									// para la segunda lectura
									proceso.setComienzaTiempo(columna + 1);
								}
							}
						}
					}
				} // fin for (fila)
			} // fin for (columna)
		} // fin si final(lstProcesosListo está vacía)
			// Carga a la matriz los estados E y T
		/*-------------- segunda pasada ------------*/
		if (!lstProcesosListo2.isEmpty()) {
			// corrige errores de comienzo de tiempo
			for (Proceso p : lstProcesosListo2) {
				/* listar procesos a la lstProcesos */
				listarProcesoFIFO(p);
				/* cargar a CPU */
				ejecutarProceso(deslistarProcesoFIFO());
				/* el CPU está en uso y comienza a escribir la tabla */
				int duracion = getHilo().getProceso().getDuracion().getfCPU();

				for (int j = 0; j < duracion; j++) {
					if (auxTabla[getHilo().getProceso().getIdProceso() - 1][finale - 1].equals("B")) {
						// Por cada bloqueado adelanto 1 para ejecutar
						// instrucciones de proceso
						for (int j2 = finale - 1; j2 < getCantidaColumnas(); j2++) {
							if (auxTabla[getHilo().getProceso().getIdProceso() - 1][j2].equals("B")) {
								finale++;
							}
						}
					}
					getHilo().ejecutarInstrucción();
					auxTabla[getHilo().getProceso().getIdProceso() - 1][finale - 1].setEstado("E");
					if (getHilo().getProceso().getDuracion().getfCPU() <= 0) {
						auxTabla[getHilo().getProceso().getIdProceso() - 1][finale].setEstado("T");
					}
					finale++;
				}
				/* si un proceso completo el uso de CPU entonces */
				terminarProceso();
			}

		} // fin si final(lstProcesosListo2 está vacía)
		/*-------------- Fin FIFO ------------*/
		return auxTabla;
	}

	@Override
	public String toString() {
		String string;

		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}

		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " ";
			}
			string += i + " |";
		}

		for (int i = 0; i < getLstProcesos().size(); i++) {

			string += "\n| " + getLstProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + getTabla()[i][j] + " |";
			}
		}

		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}

	public String toString(Tabla[][] auxTabla) {
		String string;

		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}

		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " ";
			}
			string += i + " |";
		}

		for (int i = 0; i < getLstProcesos().size(); i++) {
			string += "\n| " + getLstProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + auxTabla[i][j] + " |";
			}
		}

		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}

}
