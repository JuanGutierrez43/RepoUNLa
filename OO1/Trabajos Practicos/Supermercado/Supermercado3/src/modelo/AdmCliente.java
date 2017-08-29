package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdmCliente {
	List<Cliente> lstCliente = new ArrayList<Cliente>();
	
	public AdmCliente(){
	}
	
	public List<Cliente> getLstCliente() {
		return this.lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
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
}
