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
				+ ", Duracion=" + getDuracion()
				+ ", Prioridad=" + getPrioridad()
				+ "\n";
	}
	
	
}
