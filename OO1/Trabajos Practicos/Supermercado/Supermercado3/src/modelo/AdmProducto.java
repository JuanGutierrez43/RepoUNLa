package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdmProducto {
	List<Producto> lstProducto = new ArrayList<Producto>();
	
	public AdmProducto(){
	}
	
	public List<Producto> getLstProducto() {
		return this.lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	
	public Producto traerProducto(int idProducto) {
		boolean encontrado = false;
		Producto p = null;
		Iterator<Producto> iter = this.getLstProducto().iterator();
		while (iter.hasNext() && !encontrado) {
			p = iter.next();
			if (p.getIdProducto() == idProducto) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			p = null;
		}
		return p;
	}
	
	//este metodo no esta en el pdf pero lo hago para buscar por String cuando agrego producto
	public Producto traerProducto(String producto) {
		boolean encontrado = false;
		Producto p = null;
		Iterator<Producto> iter = this.getLstProducto().iterator();
		while (iter.hasNext() && encontrado == false) {
			p = iter.next();
			if (p.getProducto().equals(producto)) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			p = null;
		}
		return p;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		if (traerProducto(producto) != null) {
			throw new Exception("Producto ya ingresado");
		} else {
			lstProducto.add(new Producto(idMayor() + 1, producto, precio));
			return true;
		}
	}

	public int idMayor() {
		int mayor = 0;
		if (lstProducto.size() != 0) {
			mayor = lstProducto.get(0).getIdProducto();
		}
		int actual;
		for (int i = 0; i < lstProducto.size(); i++) {
			actual = lstProducto.get(i).getIdProducto();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

	//no lo pide en el nivel 2 pero ya lo tengo hecho del 1
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		boolean resu=false;
		if (productoEncontrado==null) {
			throw new Exception("Producto no encontrado");
		}else{
			productoEncontrado.setProducto(producto);
			productoEncontrado.setPrecio(precio);
			resu=true;
		}
		return resu;
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		boolean resu=false;
		if (productoEncontrado==null) {
			throw new Exception("Producto no encontrado");
		}else{
			resu=true;
			lstProducto.remove(productoEncontrado);
		}
		return resu;
	}
}
