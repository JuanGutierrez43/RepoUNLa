package Model;

public class Hilo {

	private int idHilo;
	private boolean ejecutando;
	private Proceso proceso;

	public Hilo(int idHilo) {
		this.idHilo = idHilo;
		this.ejecutando = false;
		this.proceso = null;
	}

	public int getIdHilo() {
		return idHilo;
	}

	public void setIdHilo(int idHilo) {
		this.idHilo = idHilo;
	}

	public boolean isEjecutando() {
		return ejecutando;
	}

	public void setEjecutando(boolean ejecutando) {
		this.ejecutando = ejecutando;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	/*------------------------------------------------------*/
	// Métodos
	public boolean ejecutarProceso(Proceso proceso) {
		boolean validate = false;
		if (!isEjecutando()) { // mejorado
			setProceso(proceso);
			setEjecutando(true);
			validate = true;
		}
		return validate;
	}
	
	public boolean ejecutarInstrucción() {
		boolean ejecutado = false;
		int tiempo = getProceso().getDuracion().getiCPU();
		if (tiempo >= 0) {
			getProceso().getDuracion().setiCPU(tiempo - 1);
			ejecutado = true;
		} else {
			tiempo = getProceso().getDuracion().getfCPU();
			if (tiempo >= 0) {
				getProceso().getDuracion().setfCPU(tiempo - 1);
				ejecutado = true;
			}
		}
		return ejecutado;
	}
	
	public Proceso eliminarProceso(){
		Proceso procesoAux = null;
		if (isEjecutando()) {
			procesoAux = getProceso();
			setProceso(null);
			setEjecutando(false);
		}
		return procesoAux;
	}

	@Override
	public String toString() {
		return "IdHilo=" + getIdHilo()
				+ ", Ejecutando="+ isEjecutando()
				+ ", Proceso=["+ getProceso()
				+ "]";
	}

}
