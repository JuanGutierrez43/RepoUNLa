package Model;

public class Hilo {

	private int idHilo;
	private boolean listo;
	private boolean ejecutando;
	private boolean bloqueado;

	public Hilo() {
		this.idHilo = 1;
		this.listo = true;
		this.ejecutando = false;
		this.bloqueado = false;
	}
	
	public Hilo(int idHilo, boolean listo, boolean ejecutando, boolean bloqueado) {
		this.idHilo = idHilo;
		this.listo = listo;
		this.ejecutando = ejecutando;
		this.bloqueado = bloqueado;
	}

	public int getIdHilo() {
		return idHilo;
	}

	public void setIdHilo(int idHilo) {
		this.idHilo = idHilo;
	}

	public boolean isListo() {
		return listo;
	}

	public void setListo(boolean listo) {
		this.listo = listo;
	}

	public boolean isEjecutando() {
		return ejecutando;
	}

	public void setEjecutando(boolean ejecutando) {
		this.ejecutando = ejecutando;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Override
	public String toString() {
		return "Hilo [getIdHilo()=" + getIdHilo() + ", isListo()=" + isListo() + ", isEjecutando()=" + isEjecutando()
				+ ", isBloqueado()=" + isBloqueado() + "]";
	}

	
}
