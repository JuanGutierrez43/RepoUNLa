package modelo;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public int getIdItem() {
		return this.idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Producto getProducto() {
		return this.producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ItemCarrito [idItem=" + this.idItem + ", producto=" + this.producto + ", cantidad=" + this.cantidad
				+ "]";
	}
	public float calcularSubTotal(){
		return (producto.getPrecio()*getCantidad());
	}
}
