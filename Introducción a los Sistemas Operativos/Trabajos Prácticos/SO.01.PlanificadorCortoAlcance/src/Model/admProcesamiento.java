package Model;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.sound.SimpleSoundbank;

import Model.Proceso.Prioridad;
import Model.Tabla;

public class admProcesamiento {

	private List<Proceso> lstProcesos;
	private int cantidadFilas;
	private int cantidaColumnas;
	private Tabla[][] tabla;
	private Hilo hilo;

	public admProcesamiento(int cantidadFilas, int cantidaColumnas) {
		this.lstProcesos = new ArrayList<Proceso>();
		this.cantidadFilas = cantidadFilas;
		this.cantidaColumnas = cantidaColumnas;
		this.tabla = new Tabla[cantidadFilas][cantidaColumnas];
		setTabla();
		this.hilo = new Hilo();
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
	
	/*------------------------------------------------------*/
	public Tabla[][] pranificarFIFO() {

		Tabla[][] auxTabla = new Tabla[cantidadFilas][cantidaColumnas];
		setTabla(auxTabla, tabla); //inicializo
		List<Proceso> auxLstProceso = new ArrayList<Proceso>();

		/*-------------- primera pasada ------------*/
		for (Proceso proceso : lstProcesos) {
			int idProceso=1;
			if (!auxLstProceso.isEmpty()) { // busco la id
				idProceso=proceso.getIdProceso();
			}
			Proceso auxProceso1=new Proceso(proceso.getIdProceso(),proceso.getProceso(),proceso.getComienzaTiempo(),proceso.getPrioridad(),proceso.getDuracion());
			
			if(idProceso>1){ //para todos los proceso actualizo getComienzaTiempo(); exepto para el 1ro
				int inicia=auxLstProceso.get(idProceso-2).getComienzaTiempo()+auxLstProceso.get(idProceso-2).getDuracion().getiCPU();
				if(auxProceso1.getComienzaTiempo()<=inicia){
					auxProceso1.setComienzaTiempo(auxLstProceso.get(idProceso-2).getComienzaTiempo()+auxLstProceso.get(idProceso-2).getDuracion().getiCPU());
				}
			}
			auxLstProceso.add(auxProceso1);
		}
		
		if (!auxLstProceso.isEmpty()) {
		/* por toda la tabla agrego los estados de Ejecutando y Bloqueado */
		for (int i = 0; i < getCantidaColumnas(); i++) {
			for (int k = 0; k < auxLstProceso.size(); k++) {
				/* reviso los procesos auxiliares */
				if (auxLstProceso.get(k).getComienzaTiempo() == i + 1) {
					for (int k2 = 0; k2 < auxLstProceso.get(k).getDuracion().getiCPU(); k2++) {
						// agrego todos los Estados "Ejecutando"
						auxTabla[k][i+k2].setEstado("E");
						if(k2==auxLstProceso.get(k).getDuracion().getiCPU()-1){
							// agrego todos los Estados "Bloqueado"
							for (int l = 1; l <= auxLstProceso.get(k).getDuracion().getEyS(); l++) {
								auxTabla[k][i+l+k2].setEstado("B");
							}
							
						}//fin if
					}//fin for
				}//fin if
			}//fin for (k)
		}//fin for (i)
		
		/*-------------- segunda pasada ------------*/
		int ptrfin=auxLstProceso.get(auxLstProceso.size()-1).getComienzaTiempo()+auxLstProceso.get(auxLstProceso.size()-1).getDuracion().getiCPU();
		for (int i = 0; i < auxLstProceso.size(); i++) {
			//guardo ultimo lugar disponible
			int terminaT=auxLstProceso.get(i).getDuracion().getiCPU()+auxLstProceso.get(i).getDuracion().getEyS()+auxLstProceso.get(i).getComienzaTiempo();
			for (Proceso proceso : auxLstProceso) {	
				if (proceso.getComienzaTiempo()<=ptrfin) {
					// pregunto si el proceso esta listo
					//int terminaT=proceso.getDuracion().getiCPU()+proceso.getDuracion().getEyS()+proceso.getComienzaTiempo();
					if (terminaT<=ptrfin) {
						//System.out.println("entra: "+terminaT+" de "+ptrfin);
						// busco la id
						int idProceso=proceso.getIdProceso();
						// proceso a acomodar los procesos
						
						if(idProceso==1){
							int P1=proceso.getDuracion().getiCPU()+proceso.getDuracion().getEyS();
							int Pnfin=auxLstProceso.get(auxLstProceso.size()-1).getComienzaTiempo()+auxLstProceso.get(auxLstProceso.size()-1).getDuracion().getiCPU();
							//System.out.println("P1:"+P1+" PnFin:"+ptrfin);
							if (P1>ptrfin) {
								//System.out.println("1ro: "+auxLstProceso.get(auxLstProceso.size()-1).getComienzaTiempo());
							}
							auxLstProceso.get(0).setComienzaTiempo(Pnfin);	
							//System.out.println(auxLstProceso.get(0));
							//ptrfin=auxLstProceso.get(0).getComienzaTiempo()+auxLstProceso.get(0).getDuracion().getiCPU();
						}
						
						if(idProceso>1){
							//System.out.println("2ro: "+auxLstProceso.get(0).getComienzaTiempo());
							//System.out.println(proceso);
							auxLstProceso.get(idProceso-1).setComienzaTiempo(auxLstProceso.get(idProceso-2).getComienzaTiempo()+auxLstProceso.get(idProceso-2).getDuracion().getfCPU());	
							//ptrfin=auxLstProceso.get(idProceso-1).getComienzaTiempo()+auxLstProceso.get(idProceso-1).getDuracion().getiCPU();
						}
						
					}	
				}
			}
		}
		
		/* por toda la tabla agrego los estados de Ejecutando y Terminado */
		for (int i = 0; i < getCantidaColumnas(); i++) {
			for (int k = 0; k < auxLstProceso.size(); k++) { // cambiar auxLstProceso.size()
				/* reviso los procesos auxiliares */
				if (auxLstProceso.get(k).getComienzaTiempo() == i + 1) {
					for (int k2 = 0; k2 < auxLstProceso.get(k).getDuracion().getfCPU(); k2++) {
						// agrego todos los Estados "Ejecutando"
						auxTabla[k][i+k2].setEstado("E");
						if(k2==auxLstProceso.get(k).getDuracion().getfCPU()-1){
							// agrego todos los Estados "Bloqueado"
							for (int l = 1; l <= 1; l++) {
								auxTabla[k][i+l+k2].setEstado("T");
							}
						}//fin if
					}//fin for
				}//fin if
			}//fin for (k)
		}//fin for (i)
		
		}//fin si si la lista está vacía
		System.out.println();
		return auxTabla;
	}

	public String mostrarAlgoritmoFIFO(){
		return getLstProcesos()+"\n"+toString(pranificarFIFO());
	}
	
	public Tabla[][] pranificarPrioridad(){
		Tabla[][] auxTabla = new Tabla[cantidadFilas][cantidaColumnas];
		setTabla(auxTabla, tabla); //inicializo
		List<Proceso> auxLstProceso = new ArrayList<Proceso>();
		
		for (int t= 0; t < getCantidaColumnas(); t++) {

			for (Proceso proceso : lstProcesos) {
				
				//pregunto quien entra
				if(proceso.getComienzaTiempo()==(t+1)){
					
					Proceso auxProceso1=new Proceso(proceso.getIdProceso(),proceso.getProceso(),proceso.getComienzaTiempo(),proceso.getPrioridad(),proceso.getDuracion());
					Proceso auxProceso2=new Proceso(proceso.getIdProceso(),proceso.getProceso(),proceso.getComienzaTiempo(),proceso.getPrioridad(),proceso.getDuracion());
					
					//auxProceso=proceso;
					//busco si se ejecuto por primera vez el proceso para evitar errores de duplicados
					boolean valido=true;
					for (Proceso proceso2 : auxLstProceso) {
						if (auxProceso2.equals(proceso2)) {
							valido=false;
						}
					}
					//no entran duplicados
					if (valido) {
						// modifico inicio del proceso para su segunda "Ejecución"
						//auxProceso.setComienzaTiempo(proceso.getDuracion().getiCPU()+proceso.getComienzaTiempo()+proceso.getDuracion().getEyS());
						
						
						
						if (!auxLstProceso.isEmpty()) {//esta vacia sigo
							
							//ordenamiento por "Prioridad"
							int lenD=auxLstProceso.size();
							boolean ordenado=false;
							for(int i=0;i<lenD && ordenado==false;i++){							
								if(!ordenado && auxProceso2.getPrioridad().equals(Prioridad.Baja)){
									//lo ordeno por prioridad baja
									System.out.println("baja "+auxProceso2);
									//auxProceso.setComienzaTiempo(proceso.getDuracion().getiCPU()+proceso.getComienzaTiempo()+proceso.getDuracion().getEyS());
									
									auxProceso1.setComienzaTiempo(auxLstProceso.get(lenD-1).getComienzaTiempo()+auxLstProceso.get(lenD-1).getDuracion().getfCPU());
									auxProceso2.setComienzaTiempo(auxProceso1.getComienzaTiempo()+auxProceso1.getDuracion().getiCPU());
									
									
									auxLstProceso.add(lenD,auxProceso1);
									auxLstProceso.add(lenD+1,auxProceso2);
									
									System.out.println("baja-< "+(auxLstProceso.get(lenD-1).getComienzaTiempo()));
									//auxLstProceso.get(auxLstProceso.size()-2).setComienzaTiempo(auxLstProceso.get(lenD-1).getComienzaTiempo()+1);
									//auxLstProceso.get(auxLstProceso.size()-1).setComienzaTiempo(auxLstProceso.get(lenD).getComienzaTiempo()+1);
									
									ordenado=true;
								}
								if (!ordenado && auxProceso2.getPrioridad().equals(Prioridad.Media)) {
									//System.out.println("Media "+auxProceso+" "+t);
									int contAlta=0;
									for (Proceso proceso2 : auxLstProceso) {
										if(proceso2.getPrioridad().equals(Prioridad.Alta) || proceso2.getPrioridad().equals(Prioridad.Media)){
											contAlta++;
										}
									}	
									//System.out.println("cont:"+contAlta);
									auxLstProceso.add(contAlta,proceso);
									auxLstProceso.add(contAlta+1,auxProceso2);
									ordenado=true;
								}
								if (!ordenado && auxProceso2.getPrioridad().equals(Prioridad.Alta)) {
									int contAlta=0;
									for (Proceso proceso2 : auxLstProceso) {
										if(proceso2.getPrioridad().equals(Prioridad.Alta)){
											contAlta++;
										}
									}
									auxLstProceso.add(contAlta,proceso);
									auxLstProceso.add(contAlta+1,auxProceso2);
									ordenado=true;
								}

							} //Fin for (i)
						}else{
							// modifico inicio del proceso para su segunda "Ejecución"
							auxProceso2.setComienzaTiempo(proceso.getDuracion().getiCPU()+proceso.getComienzaTiempo()+proceso.getDuracion().getEyS());
							
							auxLstProceso.add(proceso);
							auxLstProceso.add(auxProceso2);
						}//FinSi isEmpty()
						
					}//Fin si de duplicados (valido)
					
				}//Fin si de proceso n
				
				
			}//Fin for (procesos)
			
			//System.out.println(t);
		}//Fin for tiempo (t)
		System.out.println(auxLstProceso);
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

			string += "\n| " + lstProcesos.get(i).getProceso() + "\t   |";
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
			string += "\n| " + lstProcesos.get(i).getProceso() + "\t   |";
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
