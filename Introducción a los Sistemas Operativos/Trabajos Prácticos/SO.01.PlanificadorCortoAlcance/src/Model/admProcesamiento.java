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
		if (!getHilo().isEjecutando()) {
			getHilo().setProceso(proceso);
		}
		if (getHilo().getProceso().equals(proceso)) {
			getHilo().setEjecutando(true);
			validate = true;
		}
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
		validate = getBuffers().getLstProcesos().add(proceso);
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
		Proceso procesoAux = new Proceso();
		// sale el primero
		if (!getListo().getLstProcesos().isEmpty()) {
			// procesoAux = getListo().deslistarProceso(1);
			// no porque no saco por ide sino por index
			procesoAux = new Proceso(getListo().getLstProcesos().get(0).getIdProceso(),
					getListo().getLstProcesos().get(0).getProceso(),
					getListo().getLstProcesos().get(0).getComienzaTiempo(),
					getListo().getLstProcesos().get(0).getPrioridad(),
					getListo().getLstProcesos().get(0).getDuracion());
			getListo().getLstProcesos().remove(0);
		}
		return procesoAux;
	}

	// listar para Prioridades...
	/*------------------------------------------------------*/

	public String mostrarAlgoritmoFIFO() {
		return toString(planificarFIFO());
		// return getLstProcesos() + "\n" + toString(planificarFIFO());
	}

	public Tabla[][] planificarFIFO() {
		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		setTabla(auxTabla, getTabla()); // inicializo tabla nueva
		List<Proceso> lstProcesosListo = new ArrayList<Proceso>();
		// inicializo Estado listo
		List<Proceso> lstProcesos2 = new ArrayList<Proceso>();
		// inicializo Estado listo
		
		/*-------------- Inicio ------------*/
		// preparo el hilo
		getHilo().setEjecutando(false);
		// Cargo todos los procesos a un Lista Aux para no modificar datos del
		// usuario
		for (Proceso proceso : getLstProcesos()) {
			Proceso auxProceso1 = new Proceso(proceso.getIdProceso(), proceso.getProceso(), proceso.getComienzaTiempo(),
					proceso.getPrioridad(), proceso.getDuracion());
			lstProcesosListo.add(auxProceso1);
		}
		
		/*-------------- primera pasada ------------*/
		// Carga a la matriz los estados
		if (!lstProcesosListo.isEmpty()) {
			/* por toda la tabla agrego los estados */
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				for (int fila = 0; fila < lstProcesosListo.size(); fila++) {
					/* listar procesos a la lstProcesos */
					if (traerProceso(fila).getComienzaTiempo() == columna + 1) {
						// guardo proceso a listo
						listarProcesoFIFO(traerProceso(fila));
						// System.out.println(getListo());
					} // fin if
					/* reviso si CPU esta libre */
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
								bloquearProceso(terminarProceso());
							} else {
								auxTabla[fila][columna].setEstado("T");
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
							lstProcesos2.add(desbloquearProceso(fila + 1));
							for (Proceso proceso : lstProcesos2) {
								if (proceso.equal(fila + 1)) {
									// busco el proceso por su id para no tener
									// errores y seteo su tiempo de comienzo
									// para la segunda lectura
									proceso.setComienzaTiempo(columna + 1);
								}
							}
						}
					}
				} // fin for (k)
			} // fin for (i)
		} // fin si final(lista está vacía)

		/*-------------- segunda pasada ------------*/
		System.out.println(lstProcesos2);

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
