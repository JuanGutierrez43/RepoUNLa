package modelo;

public class Producto {
	private int idProducto;
	private String producto;
	private float precio;
	public Producto(int idProducto, String producto, float precio) {
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
	}
	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return this.producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public float getPrecio() {
		return this.precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + this.idProducto + ", producto=" + this.producto + ", precio=" + this.precio
				+ "]";
	}
	
	
}
