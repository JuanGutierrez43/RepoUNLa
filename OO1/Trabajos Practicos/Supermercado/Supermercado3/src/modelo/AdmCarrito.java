package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class AdmCarrito {
	List<Carrito> lstCarrito = new ArrayList<Carrito>();
	
	public AdmCarrito(){
	}
	
	public List<Carrito> getLstCarrito() {
		return this.lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	
	public boolean agregarCarrito(GregorianCalendar fechaHora, Cliente cliente) throws Exception{
		boolean encontrado = false, agregado = false;
		for (Carrito c : this.getLstCarrito()){
			if (Funciones.sonFechasHorasIguales(fechaHora, c.getFechaHora())){
				encontrado = true;
			}
		}
		if (encontrado) { 
			throw new Exception("El carrito a agregar ya existe");
		} else {
				agregado = lstCarrito.add(new Carrito(idMayorCarrito() + 1, fechaHora, cliente));
		}
		return agregado;
	}
	
	public int idMayorCarrito() {
		int mayor = 0;
		if (lstCarrito.size() != 0) {
			mayor = lstCarrito.get(0).getIdCarrito();
		}
		int actual;
		for (int i = 0; i < lstCarrito.size(); i++) {
			actual = lstCarrito.get(i).getIdCarrito();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}
	
	public Carrito traerCarrito(int idCarrito) {
		boolean encontrado = false;
		Carrito c = null;
		Iterator<Carrito> iter = this.getLstCarrito().iterator();
		while (iter.hasNext() && !encontrado) {
			c = iter.next();
			if (c.getIdCarrito() == idCarrito) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			c = null;
		}
		return c;
	}
	
	public boolean eliminarCarrito(int idCarrito) throws Exception {
		Carrito carritoEncontrado = traerCarrito(idCarrito);
		boolean resu=false;
		if (carritoEncontrado==null) {
			throw new Exception("Carrito no encontrado");
		}else{
			resu=true;
			lstCarrito.remove(carritoEncontrado);
		}
		return resu;
	}
}
