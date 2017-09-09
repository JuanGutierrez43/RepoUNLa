package Model;

public class Proceso {


	private int idProceso;
	private String proceso;
	private int comienzaTiempo;
	private Prioridad prioridad;
	private Duracion duracion;

	public Proceso() {
		this.idProceso = 0;
		this.proceso = " ";
		this.comienzaTiempo = 0;
		this.prioridad = Prioridad.Baja;
		this.duracion = new Duracion();
	}
	
	public Proceso(int idProceso, String proceso, int comienzaTiempo, Prioridad prioridad, Duracion duracion) {
		this.idProceso = idProceso;
		this.proceso = proceso;
		this.comienzaTiempo = comienzaTiempo;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public int getComienzaTiempo() {
		return comienzaTiempo;
	}

	public void setComienzaTiempo(int comienzaTiempo) {
		this.comienzaTiempo = comienzaTiempo;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Duracion getDuracion() {
		return duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	public enum Prioridad {
		Baja, Media, Alta
	};
	
	@Override
	public String toString() {
		return "Proceso="+getProceso()
				+ ", Tiempo Comienza=" + getComienzaTiempo() 
				+ ", Duración=" + getDuracion()
				+ ", Prioridad=" + getPrioridad()
				;
	}
	
	public boolean equal(int idProceso) {
		boolean validate=false;
		if (getIdProceso()==idProceso){
			validate=true;
		}
		return validate;
	}

	// nuevo
	public boolean equal(Proceso proceso) {
		boolean validate=false;
		if (this.hashCode() == proceso.hashCode()){
			validate=true;
		}
		return validate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comienzaTiempo;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + idProceso;
		result = prime * result + ((prioridad == null) ? 0 : prioridad.hashCode());
		result = prime * result + ((proceso == null) ? 0 : proceso.hashCode());
		return result;
	}
	
}
