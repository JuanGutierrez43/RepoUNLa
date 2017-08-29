package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Supermercado {
	List<Producto> gondola = new ArrayList<Producto>();
	
	public Supermercado(){
	}

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}
	
	public Producto traerProducto(int idProducto) {
		boolean encontrado = false;
		Producto p = null;
		Iterator<Producto> iter = this.getGondola().iterator();
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
		Iterator<Producto> iter = this.getGondola().iterator();
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
			gondola.add(new Producto(idMayor() + 1, producto, precio));
			return true;
		}
	}

	public int idMayor() {
		int mayor = 0;
		if (gondola.size() != 0) {
			mayor = gondola.get(0).getIdProducto();
		}
		int actual;
		for (int i = 0; i < gondola.size(); i++) {
			actual = gondola.get(i).getIdProducto();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}

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

	//consultar sobre como saber si existe en algun carrito para lanzar excepcion
	public boolean eliminarProducto(int idProducto) throws Exception {
		Producto productoEncontrado = traerProducto(idProducto);
		boolean resu=false;
		if (productoEncontrado==null) {
			throw new Exception("Producto no encontrado");
		}else{
			resu=true;
			gondola.remove(productoEncontrado);
		}
		return resu;
	}
}
