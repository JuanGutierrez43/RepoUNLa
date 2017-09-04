package Model;

public class Tabla {

	private int fila;
	private int columna;
	private String estado;

	public Tabla(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.estado = " ";
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return getEstado().toString();
	}
	
}
