package modelo;

public class Cliente {
	private int idCliente;
	private String cliente;
	private long dni;
	private String direccion;
	public Cliente(int idCliente, String cliente, long dni, String direccion) {
		this.idCliente = idCliente;
		this.cliente = cliente;
		this.dni = dni;
		this.direccion = direccion;
	}
	public int getIdCliente() {
		return this.idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCliente() {
		return this.cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public long getDni() {
		return this.dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + this.idCliente + ", cliente=" + this.cliente + ", dni=" + this.dni
				+ ", direccion=" + this.direccion + "]";
	}
	
}
