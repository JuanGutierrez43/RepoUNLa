package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Model.Proceso.Prioridad;
import Model.Tabla;

public class admProcesamiento {

	/*------------------------------------------------------*/
	// Atributos
	/*------------------------------------------------------*/
	private List<Proceso> lstProcesos;
	private int cantidadFilas;
	private int cantidaColumnas;
	private Tabla[][] tabla;
	private Hilo hilo;
	private Buffers buffers;
	private Listo listo;

	/*------------------------------------------------------*/
	// Constructor
	/*------------------------------------------------------*/
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

	/*------------------------------------------------------*/
	// Métodos Getter y Setter
	/*------------------------------------------------------*/
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
		this.tabla = newTable(); // mejoras
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

	// Crear nuevo Proceso
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

	// Traer un Proceso
	public Proceso traerProceso(int index) {
		Proceso procesoAux = null;
		if (!getLstProcesos().isEmpty() && getLstProcesos().size() > index) {
			procesoAux = getLstProcesos().get(index);
		}
		return procesoAux;
	}

	// Listar
	public boolean listarProcesoFIFO(Proceso proceso) {
		boolean validate = false;
		// Agrego al final
		validate = getListo().getLstProcesos().add(proceso);
		return validate;
	}

	public Proceso deslistarProcesoFIFO() {
		Proceso procesoAux = null;
		// Saco el primero  
		if (!getListo().getLstProcesos().isEmpty()) {
			// procesoAux = getListo().deslistarProceso(1);
			// No porque no saco por id sino por índex
			procesoAux = getListo().getLstProcesos().get(0);
			getListo().getLstProcesos().remove(0);
		}
		return procesoAux;
	}

	// Ejecutar
	public boolean ejecutarProceso(Proceso proceso) {
		boolean validate = false;
		validate = getHilo().ejecutarProceso(proceso);
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

	// Algoritmos de Procesos ->
	/*------------------------------------------------------*/

	public String mostrarAlgoritmoFIFO() {
		String string = "";
		/*-------------- traer Algoritmo FIFO ------------*/
		string += "Algoritmo FIFO";
		string += "\n" + toString(planificarFIFO(clone(getLstProcesos()), newTable()));
		string += "\n" + mostrarLstProceso();
		string += "\n-> hay 1 procesador";
		string += "\n-> E/S Se realiza en paralelo\n";
		return string;
	}

	public Tabla[][] planificarFIFO(List<Proceso> procesos, Tabla[][] auxTabla) {
		/*-------------- Inicio FIFO------------*/
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contador para cargar estado
		int cont = procesos.size();
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Paso proceso a listo de la tabla  
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
					}
				}
				// Paso de proceso Bloqueado a listo
				listarProcesoBloqueado();
				// No tiene Ordenar

				// Sacar un proceso de listo y lo paso al CPU  
				prosesarProceso();
				// Reviso CPU y ejecuto proceso 
				if (ejecutar(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior paso otro proceso ha estado Ejecutando 
					ejecutar(auxTabla,columna);
				}
				// Las E/S se realiza en paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}

	public String mostrarAlgoritmoPrioridad() {
		String string = "";
		/*-------------- traer Algoritmo Prioridad ------------*/
		string += "Algoritmo Prioridad";
		string += "\n" + toString(planificarPrioridad(clone(getLstProcesos()), newTable()));
		string += "\n" + mostrarLstProceso();
		string += "\n-> hay 1 procesador";
		string += "\n-> E/S Se realiza en paralelo";	
		return string;
	}

	private Tabla[][] planificarPrioridad(List<Proceso> procesos, Tabla[][] auxTabla) {
		/*-------------- Inicio Planificar Prioridad------------*/
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contador para cargar estado
		int cont = procesos.size();
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) {
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++) {
				// Paso proceso a listo de la tabla  
				if (cont >= 0) {
					if (listarProcesoEntrada(procesos,columna)) {
						cont--;
					}
				}
				// Paso de proceso Bloqueado a listo
				listarProcesoBloqueado();
				// Ordeno por Prioridad
				getListo().ordenarPrioridad();
				// Sacar un proceso de listo y lo paso al CPU  
				prosesarProceso();
				// Reviso CPU y ejecuto proceso 
				if (ejecutar(auxTabla,columna)) {
					prosesarProceso(); // Caso de que se bloquea o termina Proceso anterior paso otro proceso ha estado Ejecutando 
					ejecutar(auxTabla,columna);
				}
				// Las E/S se realiza en paralelo
				ejecutarEyS(auxTabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return auxTabla;
	}

	
	// Módulos para los planificadores ->
	/*------------------------------------------------------*/
	public boolean listarProcesoEntrada(List<Proceso> procesos,int columna){
		boolean add=false;
		for (int fila = 0; fila < procesos.size(); fila++) {
			if (procesos.get(fila).getComienzaTiempo() == (columna + 1)) {
				// Guardo proceso a listo
				listarProcesoFIFO(procesos.get(fila));
				// Ordeno por prioridad lista de Listos 
				add=true;
			}
		}// Procesos por fila
		return add;
	}
	
	public boolean listarProcesoBloqueado(){
		boolean add=false;
		int i = 0;
		int reiniciar = getBuffers().getLstProcesos().size();
		int lenD = getBuffers().getLstProcesos().size();
		while (reiniciar > 0) {// Solución para sacar más bloqueados 
			i = 0;
			while (i < lenD) {
				if (getBuffers().getLstProcesos().get(i).getDuracion().getEyS() <= 0) {
					listarProcesoFIFO(desbloquearProceso(getBuffers().getLstProcesos().get(i).getIdProceso()));
					// Como saque un Proceso, entonces
					lenD--;
					i = getBuffers().getLstProcesos().size();
					add=true;
				}
				i++;
			}
			reiniciar--;
		}
		return add;
	}
	
	public boolean prosesarProceso(){
		boolean load=false;
		// Reviso si CPU esta libre para agregar un proceso nuevo 
		if (!getHilo().isEjecutando()) {
			// Sacar un proceso de listo y lo paso al CPU 
			if (!getListo().getLstProcesos().isEmpty()) {
				load=ejecutarProceso(deslistarProcesoFIFO());
			}
		}
		return load;
	}
	
	public boolean ejecutar(Tabla[][] auxTabla,int columna){
		
		boolean ejecutando=false;
		boolean bloquear=true;
		boolean nuevo=false;
		if (getHilo().isEjecutando()) {
			ejecutando = getHilo().ejecutarInstrucción();
			// cargo a la tabla estado E caso 1
			if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() >= 0) {
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Cargo a la tabla estado E caso 2
			if (ejecutando && getHilo().getProceso().getDuracion().getfCPU() >= 0) {
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Paso el proceso a bloqueado o lo Termino
			if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1 && getHilo().getProceso().getDuracion().getfCPU() == -1) {
				auxTabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("T");
				terminarProceso(); // elimino el Proceso
				bloquear = false; // aviso que no bloquee
				nuevo=true;
			}
			if (bloquear) {// no tira error de hilo vacío cuidado con esta parte que puede ser causa errores por la id que traigo que es distinto que el index :) Revisar a futuro porque me daba error
				if (ejecutando && getHilo().getProceso().getDuracion().getiCPU() == -1 && getHilo().getProceso().getDuracion().getfCPU() == traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getfCPU()) {
					bloquearProceso(terminarProceso());
					nuevo=true;
				}
			}
		}
		return nuevo;
	}
	
	public boolean ejecutarEyS(Tabla[][] auxTabla,int columna){
		boolean run=false;
		if (!getBuffers().getLstProcesos().isEmpty() ) {
			for (Proceso proceso : getBuffers().getLstProcesos()) {
				if (proceso.getDuracion().getEyS() > 0) {
					getBuffers().ejecutarEyS(proceso.getIdProceso());
					auxTabla[proceso.getIdProceso() - 1][columna].setEstado("B");
					run=true;
				}
			}
		}
		return run;
	}
	// @Override ->
	/*------------------------------------------------------*/
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

	public List<Proceso> clone(List<Proceso> lstProcesos){
		List<Proceso> lstProcesosAux = new ArrayList<Proceso>();
		/*-------------- Respaldo Datos Originales ------------*/
		for (Proceso proceso : lstProcesos) {
			Proceso auxProceso1 = proceso.clone(); // Nuevo¡¡¡ 2017
			lstProcesosAux.add(auxProceso1);
		}
		return lstProcesosAux;
	}

	public Tabla[][] newTable(){
		Tabla[][] auxTabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];
		/*--------------    Preparar nueva Tabla   ------------*/
		for (int i = 0; i < getCantidadFilas(); i++) {
			for (int j = 0; j < getCantidaColumnas(); j++) {
				auxTabla[i][j] = new Tabla(i + 1, j + 1);
			}
		}
		return auxTabla;
	}
	
	public String mostrarLstProceso() {
		String string = "";
		for (Proceso proceso : getLstProcesos()) {
			string += proceso + "\n";
		}
		return string;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		admProcesamiento other = (admProcesamiento) obj;
		if (cantidaColumnas != other.cantidaColumnas)
			return false;
		if (cantidadFilas != other.cantidadFilas)
			return false;
		if (lstProcesos == null) {
			if (other.lstProcesos != null)
				return false;
		} else if (!lstProcesos.equals(other.lstProcesos))
			return false;
		if (!Arrays.deepEquals(tabla, other.tabla))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidaColumnas;
		result = prime * result + cantidadFilas;
		result = prime * result + ((lstProcesos == null) ? 0 : lstProcesos.hashCode());
		result = prime * result + Arrays.deepHashCode(tabla);
		return result;
	}
	
	public int hashCode(Tabla[][] table) {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(table);
		return result;
	}
	
}
