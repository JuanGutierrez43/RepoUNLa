package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import modelo.Funciones;

public class Supermercado {
	private AdmProducto admProducto;
	private AdmCliente admCliente;
	private AdmCarrito admCarrito;
	
	public Supermercado(AdmProducto admProducto, AdmCliente admCliente, AdmCarrito admCarrito) {
		this.admProducto = admProducto;
		this.admCliente = admCliente;
		this.admCarrito = admCarrito;
	}
	
	public AdmProducto getAdmProducto() {
		return this.admProducto;
	}

	public void setAdmProducto(AdmProducto admProducto) {
		this.admProducto = admProducto;
	}

	public AdmCliente getAdmCliente() {
		return this.admCliente;
	}

	public void setAdmCliente(AdmCliente admCliente) {
		this.admCliente = admCliente;
	}

	public AdmCarrito getAdmCarrito() {
		return this.admCarrito;
	}

	public void setAdmCarrito(AdmCarrito admCarrito) {
		this.admCarrito = admCarrito;
	}
	
	public float calcularTotal(Cliente cliente) throws Exception {
		float total = 0;
		boolean encontrado = false;
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
			for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
		for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
			for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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
			for (Carrito c : this.getAdmCarrito().getLstCarrito()){
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



