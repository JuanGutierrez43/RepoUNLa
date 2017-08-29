package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Iterator;

public class Carrito {
	private int idCarrito;
	private GregorianCalendar fechaHora;
	List<ItemCarrito> lstItem = new ArrayList<ItemCarrito>();
	private Cliente cliente;
	public Carrito(){
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}
	public Carrito(int idCarrito, GregorianCalendar fechaHora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fechaHora = fechaHora;
		this.cliente = cliente;
	}
	public int getIdCarrito() {
		return this.idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public GregorianCalendar getFechaHora() {
		return this.fechaHora;
	}
	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + this.idCarrito + ", fechaHora=" + this.fechaHora + ", lstItem=" + this.lstItem
				+ ", cliente=" + this.cliente + "]";
	}

	public boolean agregarItem(Producto producto, int cantidad){
		ItemCarrito i=null;
		if (traerItemCarrito(producto) != null) {
			traerItemCarrito(producto).setCantidad(traerItemCarrito(producto).getCantidad()+cantidad);
		} else {
			lstItem.add(new ItemCarrito(idMayor() + 1, producto, cantidad));
		}
		return true;
	}

	public int idMayor() {
		int mayor = 0;
		if (lstItem.size() != 0) {
			mayor = lstItem.get(0).getIdItem();
		}
		int actual;
		for (int i = 0; i < lstItem.size(); i++) {
			actual = lstItem.get(i).getIdItem();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}
	
	//no esta en el pdf pero lo hago para ver si funciona el agregar y eliminar item
	public ItemCarrito traerItemCarrito(int idItem) {
		boolean encontrado = false;
		ItemCarrito i = null;
		Iterator<ItemCarrito> iter = this.getLstItem().iterator();
		while (iter.hasNext() && !encontrado) {
			i = iter.next();
			if (i.getIdItem() == idItem) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			i = null;
		}
		return i;
	}
	
	//no esta en el pdf pero lo hago para agregarItem
	public ItemCarrito traerItemCarrito(Producto producto) {
		boolean encontrado = false;
		ItemCarrito i = null;
		Iterator<ItemCarrito> iter = this.getLstItem().iterator();
		while (iter.hasNext() && !encontrado) {
			i = iter.next();
			if (i.getProducto().equals(producto)) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			i = null;
		}
		return i;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito itemEncontrado = traerItemCarrito(producto);
		boolean resu=false;
		if (itemEncontrado==null) {
			throw new Exception("Item no encontrado");
		}else{
			if (itemEncontrado.getCantidad()==cantidad){
				lstItem.remove(itemEncontrado);
			} else {
				itemEncontrado.setCantidad(itemEncontrado.getCantidad()-cantidad);
			}
			resu=true;
		}
		return resu;
	}
	
	public float calcularTotal(){
		float total = 0;
		for (ItemCarrito item : this.getLstItem()){
			total += item.calcularSubTotal();
		}
		return total;
	}
}
	
