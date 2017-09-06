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
		validate=getBuffers().getLstProcesos().add(proceso);
		return validate;
	}

	public Proceso desbloquearProceso(int idProceso) {
		Proceso procesoAux =  new Proceso();
		if (!getBuffers().getLstProcesos().isEmpty() && getBuffers().getLstProcesos().size() >= idProceso) {
			procesoAux = getBuffers().eliminarBloqueado(idProceso);
		}
		return procesoAux;
	}

	// listo para FIFO
	public boolean listarProcesoFIFO(Proceso proceso) {
		boolean validate = false;
		//agrego al final
		validate=getListo().getLstProcesos().add(proceso);
		return validate;
	}
	
	public Proceso deslistarProcesoFIFO() {
		Proceso procesoAux = new Proceso();
		//sale el primero
		if (!getBuffers().getLstProcesos().isEmpty()) {
			procesoAux = getListo().getLstProcesos().get(0);
			getListo().getLstProcesos().remove(0);
		}
		return procesoAux;
	}

	//listar para Prioridades...
	//
	//
	/*------------------------------------------------------*/
	public String mostrarAlgoritmoFIFO() {
		return toString(planificarFIFO());
		// return getLstProcesos() + "\n" + toString(planificarFIFO());
	}

	public Tabla[][] planificarFIFO() {

		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		setTabla(auxTabla, getTabla()); // inicializo tabla nueva
		List<Proceso> lstProcesosListo = new ArrayList<Proceso>(); // inicializo
																	// Estado
																	// listo
		/*-------------- Inicio ------------*/
		// preparo el hilo
		getHilo().setEjecutando(false);
		// cargo el primer proceso

		// Cargo todos los procesos a un Lista Aux
		for (Proceso proceso : getLstProcesos()) {
			int idProceso = 1;
			if (!lstProcesosListo.isEmpty()) { // busco la id
				idProceso = proceso.getIdProceso();
			}
			Proceso auxProceso1 = new Proceso(proceso.getIdProceso(), proceso.getProceso(), proceso.getComienzaTiempo(),
					proceso.getPrioridad(), proceso.getDuracion());
			if (idProceso > 1) { // para todos los proceso actualizo
									// getComienzaTiempo(); exepto para el 1ro
				int inicia = lstProcesosListo.get(idProceso - 2).getComienzaTiempo()
						+ lstProcesosListo.get(idProceso - 2).getDuracion().getiCPU();
				if (auxProceso1.getComienzaTiempo() <= inicia) {
					auxProceso1.setComienzaTiempo(lstProcesosListo.get(idProceso - 2).getComienzaTiempo()
							+ lstProcesosListo.get(idProceso - 2).getDuracion().getiCPU());
				}
			}
			lstProcesosListo.add(auxProceso1);
		}
		//
		/*-------------- primera pasada ------------*/
		// Carga a la matriz estados E y B
		if (!lstProcesosListo.isEmpty()) {
			/* por toda la tabla agrego los estados de Ejecutando y Bloqueado */
			for (int i = 0; i < getCantidaColumnas(); i++) {
				for (int k = 0; k < lstProcesosListo.size(); k++) {
					/* reviso los procesos auxiliares */
					if (lstProcesosListo.get(k).getComienzaTiempo() == i + 1) {
						for (int k2 = 0; k2 < lstProcesosListo.get(k).getDuracion().getiCPU(); k2++) {
							// agrego todos los Estados "Ejecutando"
							auxTabla[k][i + k2].setEstado("E");
							if (k2 == lstProcesosListo.get(k).getDuracion().getiCPU() - 1) {
								// agrego todos los Estados "Bloqueado"
								for (int l = 1; l <= lstProcesosListo.get(k).getDuracion().getEyS(); l++) {
									auxTabla[k][i + l + k2].setEstado("B");
								}
							} // fin if
						} // fin for
					} // fin if
				} // fin for (k)
			} // fin for (i)
				// ----bien----
				//
			/*-------------- segunda pasada ------------*/
			// Busco y ordeno Procesos
			// ---corregir---
			// ptrfin donde esta libre
			int ptrfin = lstProcesosListo.get(lstProcesosListo.size() - 1).getComienzaTiempo()
					+ lstProcesosListo.get(lstProcesosListo.size() - 1).getDuracion().getiCPU();
			//
			// reviso la tabla si esta libre
			boolean bool = false;
			while (!bool) {
				if (!auxTabla[0][ptrfin - 1].getEstado().equals(" ")) {
					ptrfin++;
				} else {
					bool = true;
				}
			}
			// agrego procediminetos
			// System.out.println("libre" + ptrfin);
			for (int i = 0; i < lstProcesosListo.size(); i++) {
				// guardo último lugar disponible
				int terminaT = lstProcesosListo.get(i).getDuracion().getiCPU()
						+ lstProcesosListo.get(i).getDuracion().getEyS() + lstProcesosListo.get(i).getComienzaTiempo();
				// System.out.println(terminaT);
				for (Proceso proceso : lstProcesosListo) {
					if (proceso.getComienzaTiempo() <= ptrfin) {
						// pregunto si el proceso esta listo
						// int
						// terminaT=proceso.getDuracion().getiCPU()+proceso.getDuracion().getEyS()+proceso.getComienzaTiempo();
						if (terminaT <= ptrfin) {
							// busco la id
							int idProceso = proceso.getIdProceso();
							// proceso a acomodar los procesos
							if (idProceso == 1) {
								int P1 = proceso.getDuracion().getiCPU() + proceso.getDuracion().getEyS();
								int Pnfin = lstProcesosListo.get(lstProcesosListo.size() - 1).getComienzaTiempo()
										+ lstProcesosListo.get(lstProcesosListo.size() - 1).getDuracion().getiCPU();
								// System.out.println("P1:"+P1+"
								// PnFin:"+ptrfin);
								if (P1 > ptrfin) {
									// System.out.println("1ro:
									// "+auxLstProceso.get(auxLstProceso.size()-1).getComienzaTiempo());
								}
								lstProcesosListo.get(0).setComienzaTiempo(Pnfin);
							}
							if (idProceso > 1) {
								lstProcesosListo.get(idProceso - 1)
										.setComienzaTiempo(lstProcesosListo.get(idProceso - 2).getComienzaTiempo()
												+ lstProcesosListo.get(idProceso - 2).getDuracion().getfCPU());
							}
						}
					}
				}
			}
			//
			//
			// Carga a la matriz estados E y T
			for (int i = 0; i < getCantidaColumnas(); i++) {
				for (int k = 0; k < lstProcesosListo.size(); k++) { // cambiar
																	// auxLstProceso.size()
					/* reviso los procesos auxiliares */
					if (lstProcesosListo.get(k).getComienzaTiempo() == i + 1) {
						for (int k2 = 0; k2 < lstProcesosListo.get(k).getDuracion().getfCPU(); k2++) {
							// agrego todos los Estados "Ejecutando"
							auxTabla[k][i + k2].setEstado("E");
							if (k2 == lstProcesosListo.get(k).getDuracion().getfCPU() - 1) {
								// agrego todos los Estados "Bloqueado"
								for (int l = 1; l <= 1; l++) {
									auxTabla[k][i + l + k2].setEstado("T");
								}
							} // fin if
						} // fin for
					} // fin if
				} // fin for (k)
			} // fin for (i)
				//
			/*-------------- tercera pasada ------------*/
			// Solución para los estados B largos, tercera vuelta

		} // fin si final(lista está vacía)
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
