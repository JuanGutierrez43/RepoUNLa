package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import modelo.Funciones;

public class Supermercado {
	List<Producto> lstProducto = new ArrayList<Producto>();
	List<Cliente> lstCliente = new ArrayList<Cliente>();
	List<Carrito> lstCarrito = new ArrayList<Carrito>();
	
	public Supermercado(){
	}
	
	public List<Producto> getLstProducto() {
		return this.lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public List<Cliente> getLstCliente() {
		return this.lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public List<Carrito> getLstCarrito() {
		return this.lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
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
	
	public boolean agregarCliente (String cliente, long dni, String direccion) throws Exception {
		if (traerCliente(cliente) != null) {
			throw new Exception("Cliente ya ingresado");
		} else {
			lstCliente.add(new Cliente(idMayorCliente() + 1, cliente, dni, direccion));
			return true;
		}
	}
	
	public int idMayorCliente() {
		int mayor = 0;
		if (lstCliente.size() != 0) {
			mayor = lstCliente.get(0).getIdCliente();
		}
		int actual;
		for (int i = 0; i < lstCliente.size(); i++) {
			actual = lstCliente.get(i).getIdCliente();
			if (actual > mayor) {
				mayor = actual;
			}
		}
		return mayor;
	}
	
	public Cliente traerCliente(int idCliente) {
		boolean encontrado = false;
		Cliente c = null;
		Iterator<Cliente> iter = this.getLstCliente().iterator();
		while (iter.hasNext() && !encontrado) {
			c = iter.next();
			if (c.getIdCliente() == idCliente) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			c = null;
		}
		return c;
	}
	
	//este metodo no esta en el pdf pero lo hago para buscar por String cuando agrego cliente
	public Cliente traerCliente(String cliente) {
		boolean encontrado = false;
		Cliente c = null;
		Iterator<Cliente> iter = this.getLstCliente().iterator();
		while (iter.hasNext() && encontrado == false) {
			c = iter.next();
			if (c.getCliente().equals(cliente)) {
				encontrado = true;
			}
		}
		if (!encontrado) {
			c = null;
		}
		return c;
	}
	
	public boolean eliminarCliente(int idCliente) throws Exception {
		Cliente clienteEncontrado = traerCliente(idCliente);
		boolean resu=false;
		if (clienteEncontrado==null) {
			throw new Exception("Cliente no encontrado");
		}else{
			resu=true;
			lstCliente.remove(clienteEncontrado);
		}
		return resu;
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
		
	public float calcularTotal(Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (Carrito c : this.getLstCarrito()){
			if (c.getCliente().equals(cliente)){
				encontrado = true;
				for (ItemCarrito item : c.getLstItem()){
					total += item.calcularSubTotal();
				}
			}
		}
		if (!encontrado) throw new Exception("El cliente no existe");
		return total;
	}
	
	public float calcularTotal(int dniCliente) throws Exception {
		float total = 0;
		boolean existe = false;
		for (Carrito c : this.getLstCarrito()){
			if (c.getCliente().getDni() == dniCliente){
				existe = true;
				for (ItemCarrito item : c.getLstItem()){
					total += item.calcularSubTotal();
				}
			}
		}
		if (!existe) throw new Exception("El cliente no existe");
		return total;
	}
	
	public float calcularTotal(GregorianCalendar fechaInicio, GregorianCalendar fechaFin){
		float total = 0;
		for (Carrito c : this.getLstCarrito()){
			//entre la fecha de inicio y fin = si la fecha es menor que la fechaFin y mayor a la fechaInicio
			if (Funciones.esFechaMenor(c.getFechaHora(), fechaFin) && Funciones.esFechaMayor(c.getFechaHora(),fechaInicio)){
				for (ItemCarrito item : c.getLstItem()){
					total += item.calcularSubTotal();
				}
			}
		}
		return total;
	}
	
	public float calcularTotal(GregorianCalendar fecha){
		float total = 0;
		for (Carrito c : getLstCarrito()){
			if (Funciones.sonFechasHorasIguales(fecha, c.getFechaHora())){
				for (ItemCarrito item : c.getLstItem()){
					total += item.calcularSubTotal();
				}
			}
		}
		return total;
	}
	
	public float calcularTotal(int mes, int anio)  throws Exception{
		float total = 0;
		Funciones f=null;
		if (mes<1 || mes>12){
			throw new Exception("Mes invalido");
		} else {
			for (Carrito c : getLstCarrito()){
				//hago mes-1 porque java cuenta los meses de 0 a 11
				if (anio==f.traerAnio(c.getFechaHora()) && mes==f.traerMes(c.getFechaHora())){
					for (ItemCarrito item : c.getLstItem()){
						total += item.calcularSubTotal();
					}
				}
			}
		}
		return total;
	}
	
	public float calcularTotal(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, Cliente cliente) throws Exception{
		float total = 0;
		boolean existe = false;
		for (Carrito c : this.getLstCarrito()){
			if (c.getCliente().equals(cliente)){
				existe = true;
				//entre la fecha de inicio y fin = si la fecha es menor que la fechaFin y mayor a la fechaInicio
				if (Funciones.esFechaMenor(c.getFechaHora(), fechaFin) && Funciones.esFechaMayor(c.getFechaHora(),fechaInicio)){
					for (ItemCarrito item : c.getLstItem()){
						total += item.calcularSubTotal();
					}
				}
			}
		}
		if (!existe) throw new Exception("El cliente no existe");
		return total;
	}
	
	public float calcularTotal(GregorianCalendar fecha, Cliente cliente) throws Exception{
		float total = 0;
		boolean existe = false;
		for (Carrito c : this.getLstCarrito()){
			if (c.getCliente().equals(cliente)){
				existe = true;
				if (Funciones.sonFechasHorasIguales(fecha, c.getFechaHora())){
					for (ItemCarrito item : c.getLstItem()){
						total += item.calcularSubTotal();
					}
				}
			}
		}
		if (!existe) throw new Exception("El cliente no existe");
		return total;
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente)  throws Exception{
		float total = 0;
		Funciones f=null;
		boolean existe = false;
		if (mes<1 || mes>12){
			throw new Exception("Mes invalido");
		} else {
			for (Carrito c : getLstCarrito()){
				if (c.getCliente().equals(cliente)){
					existe = true;
					//hago mes-1 porque java cuenta los meses de 0 a 11
					if (anio==f.traerAnio(c.getFechaHora()) && mes==f.traerMes(c.getFechaHora())){
						for (ItemCarrito item : c.getLstItem()){
							total += item.calcularSubTotal();
						}
					}
				}
			}
		}
		if (!existe) throw new Exception("El cliente no existe");
		return total;
	}
	
	public float calcularTotal(int mes, int anio, int dniCliente)  throws Exception{
		float total = 0;
		Funciones f=null;
		boolean existe = false;
		if (mes<1 || mes>12){
			throw new Exception("Mes invalido");
		} else {
			for (Carrito c : getLstCarrito()){
				if (c.getCliente().getDni() == dniCliente){
					existe = true;
					//hago mes-1 porque java cuenta los meses de 0 a 11
					if (anio==f.traerAnio(c.getFechaHora()) && mes==f.traerMes(c.getFechaHora())){
						for (ItemCarrito item : c.getLstItem()){
							total += item.calcularSubTotal();
						}
					}
				}
			}
		}
		if (!existe) throw new Exception("El cliente no existe");
		return total;
	}
}



