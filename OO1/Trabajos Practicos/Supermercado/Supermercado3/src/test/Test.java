package test;
import modelo.Supermercado;
import modelo.Producto;
import modelo.ItemCarrito;
import java.util.GregorianCalendar;
import modelo.AdmCliente;
import modelo.AdmProducto;
import modelo.AdmCarrito;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Funciones;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		AdmProducto admP = new AdmProducto();
		AdmCliente admCl = new AdmCliente();
		AdmCarrito admCa = new AdmCarrito();
		Supermercado s1 = new Supermercado(admP,admCl,admCa);
		try {
			System.out.println("********1*********"); //agrego producto
			System.out.println(s1.getAdmProducto().agregarProducto("Manteca",30));
			System.out.println("********2*********"); //agrego producto, pero ya esta ingresado, tira excepcion
			System.out.println(s1.getAdmProducto().agregarProducto("Manteca",30));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try {
			System.out.println("********3*********"); //agrego producto
			System.out.println(s1.getAdmProducto().agregarProducto("Leche",25));
			System.out.println(s1.getAdmProducto().agregarProducto("Alfajor",20));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********4*********"); //traigo producto por String
		System.out.println(s1.getAdmProducto().traerProducto("Manteca"));
		System.out.println("********5*********"); //traigo producto, como no existe devuelve null
		System.out.println(s1.getAdmProducto().traerProducto("Dulce de Leche"));
		System.out.println("********6*********"); //traigo producto por String
		System.out.println(s1.getAdmProducto().traerProducto("Leche"));
		System.out.println("********7*********"); //traigo producto por String
		System.out.println(s1.getAdmProducto().traerProducto("Alfajor"));
		System.out.println("********8*********"); //traigo producto por id
		System.out.println(s1.getAdmProducto().traerProducto(1));
		System.out.println("********9*********"); //traigo producto por id
		System.out.println(s1.getAdmProducto().traerProducto(2));
		System.out.println("********10*********"); //traigo producto por id
		System.out.println(s1.getAdmProducto().traerProducto(3));
		System.out.println("********11*********"); //traigo producto, como no existe devuelve null
		System.out.println(s1.getAdmProducto().traerProducto(4));
		try {
			System.out.println("********12*********");//modifico Alfajor por Dulce de leche
			System.out.println(s1.getAdmProducto().modificarProducto(3,"Dulce de leche",70));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("********13*********"); //traigo el producto que modifique
		System.out.println(s1.getAdmProducto().traerProducto(3));
		try {
			System.out.println("********14*********"); //modifico producto, como no existe tira excepcion
			System.out.println(s1.getAdmProducto().modificarProducto(5,"Turron",8));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("********15*********"); //agrego producto
			System.out.println(s1.getAdmProducto().agregarProducto("Barra",12));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********16*********"); //traigo producto
		System.out.println(s1.getAdmProducto().traerProducto("Barra"));
		try {
			System.out.println("********17*********"); //elimino producto
			System.out.println(s1.getAdmProducto().eliminarProducto(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********18*********"); //traigo producto que elimine, devuelve null
		System.out.println(s1.getAdmProducto().traerProducto(4));
		try {
			System.out.println("********19*********"); //elimino producto, como no existe tiro excepcion
			System.out.println(s1.getAdmProducto().eliminarProducto(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		Carrito c1 = new Carrito();
		System.out.println("********20*********"); //agrego item manteca
		System.out.println(c1.agregarItem(s1.getAdmProducto().traerProducto(1),2));
		System.out.println("********21*********"); //traigo item 1
		System.out.println(c1.traerItemCarrito(1));
		System.out.println("********22*********"); //agrego item manteca, se le suma la cantidad
		System.out.println(c1.agregarItem(s1.getAdmProducto().traerProducto(1),2));
		System.out.println("********23*********"); //traigo item 1 con mas cantidad
		System.out.println(c1.traerItemCarrito(1));
		System.out.println("********24*********"); //traigo producto para ver cual es y agregarlo
		System.out.println(s1.getAdmProducto().traerProducto(2)); 
		System.out.println("********25*********"); //agrego item leche
		System.out.println(c1.agregarItem(s1.getAdmProducto().traerProducto(2),5));
		System.out.println("********26*********"); //traigo item 2
		System.out.println(c1.traerItemCarrito(2)); 
		try {
			System.out.println("********27*********"); //resto cantidad de item 2
			System.out.println(c1.eliminarItem(s1.getAdmProducto().traerProducto(2),3));
			System.out.println("********28*********");//traigo item 2
			System.out.println(c1.traerItemCarrito(2)); 
			System.out.println("********29*********"); //elimino item 2
			System.out.println(c1.eliminarItem(s1.getAdmProducto().traerProducto(2),2));
			System.out.println("********30*********");//traigo item 2, devuelve null porque ya no existe
			System.out.println(c1.traerItemCarrito(2)); 
			System.out.println("********31*********"); //elimino item, como no existe tiro excepcion
			System.out.println(c1.eliminarItem(s1.getAdmProducto().traerProducto(3),5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********32*********"); //calculo subtotal 4 mantecas * 30 = 120
		System.out.println(c1.traerItemCarrito(1).calcularSubTotal()); 
		System.out.println("********33*********"); //traigo producto 3
		System.out.println(s1.getAdmProducto().traerProducto(3));
		System.out.println("********34*********"); //agrego dulce de leche
		System.out.println(c1.agregarItem(s1.getAdmProducto().traerProducto(3),5));
		System.out.println("********35*********"); //calculo total (4 mantecas * 30)+(5 dulce de leche * 70)= 120+350 = 470
		System.out.println(c1.calcularTotal());
		
		//supermercado2
		try{
			System.out.println("********36*********"); //agrego cliente
			System.out.println(s1.getAdmCliente().agregarCliente("Ezequiel Leotta",40423033,"Mentruyt 1443"));
			System.out.println("********37*********"); //traigo cliente
			System.out.println(s1.getAdmCliente().traerCliente(1));
			System.out.println("********38*********"); //agrego cliente, como ya exsite lanza excepcion
			System.out.println(s1.getAdmCliente().agregarCliente("Ezequiel Leotta",40423033,"Mentruyt 1443"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
		System.out.println("********39*********"); //agrego cliente
		System.out.println(s1.getAdmCliente().agregarCliente("Juan Gutierrez",40125698,"Larroque 1546"));
		System.out.println("********40*********"); //traigo cliente
		System.out.println(s1.getAdmCliente().traerCliente(2));
		System.out.println("********41*********"); //elimino cliente
		System.out.println(s1.getAdmCliente().eliminarCliente(2));
		System.out.println("********42*********"); //traigo cliente que no existe, devuelve null
		System.out.println(s1.getAdmCliente().traerCliente(2));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			System.out.println("********43*********"); //agrego carrito
			Funciones f = new Funciones();
			System.out.println(s1.getAdmCarrito().agregarCarrito(f.traerFecha("15/06/1997"),s1.getAdmCliente().traerCliente(1)));
			System.out.println("********44*********"); //traigo carrito
			System.out.println(s1.getAdmCarrito().traerCarrito(1));
			System.out.println("********45*********"); //elimino carrito
			System.out.println(s1.getAdmCarrito().eliminarCarrito(1));
			System.out.println("********46*********"); //traigo carrito eliminado
			System.out.println(s1.getAdmCarrito().traerCarrito(1));
			System.out.println("********48*********"); //agrego carrito para calcular el total
			System.out.println(s1.getAdmCarrito().agregarCarrito(f.traerFecha("16/06/1997"),s1.getAdmCliente().traerCliente(1)));
			System.out.println("********49*********"); //traigo carrito
			System.out.println(s1.getAdmCarrito().traerCarrito(1));
			System.out.println("********50*********"); //traigo los productos para recordarlos
			System.out.println(s1.getAdmProducto().getLstProducto());
			System.out.println("********51*********"); //agrego manteca al carrito 5*30=150
			System.out.println(s1.getAdmCarrito().traerCarrito(1).agregarItem(s1.getAdmProducto().traerProducto(1),5));
			System.out.println("********52*********"); //agrego leche al carrito 5*25=125
			System.out.println(s1.getAdmCarrito().traerCarrito(1).agregarItem(s1.getAdmProducto().traerProducto(2),5));
			System.out.println("********53*********"); //calculo total de cliente 1 = 150+125=275
			System.out.println(s1.calcularTotal(s1.getAdmCliente().traerCliente(1)));
			System.out.println("********54*********"); //calculo total de cliente 1 = 150+125=275
			System.out.println(s1.calcularTotal(40423033));
			System.out.println("********55*********"); //calculo total de cliente que no existe
			System.out.println(s1.calcularTotal(s1.getAdmCliente().traerCliente(2)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			System.out.println("********56*********"); //calculo total de cliente que no existe
			System.out.println(s1.calcularTotal(5698741));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			Funciones f = new Funciones();
			System.out.println("********57*********"); //agrego cliente 2
			System.out.println(s1.getAdmCliente().agregarCliente("Victor Ibanez",38412879,"Larroque 4789"));
			System.out.println("********58*********"); //agrego carrito de cliente 2
			System.out.println(s1.getAdmCarrito().agregarCarrito(f.traerFecha("06/06/1997"),s1.getAdmCliente().traerCliente(2)));
			System.out.println("********59*********"); //agrego manteca al carrito 10*30=300
			System.out.println(s1.getAdmCarrito().traerCarrito(2).agregarItem(s1.getAdmProducto().traerProducto(1),10));
			System.out.println("********60*********"); //agrego leche al carrito 10*25=250
			System.out.println(s1.getAdmCarrito().traerCarrito(2).agregarItem(s1.getAdmProducto().traerProducto(2),10));
			System.out.println("********61*********"); //calculo total de cliente 2 = 300+250=550
			System.out.println(s1.calcularTotal(s1.getAdmCliente().traerCliente(2)));
			System.out.println("********62*********"); ////total cliente 1
			System.out.println(s1.calcularTotal(f.traerFecha("15/06/1997"),f.traerFecha("18/06/1997")));
			System.out.println("********63*********"); ////total cliente 2
			System.out.println(s1.calcularTotal(f.traerFecha("06/06/1997"),f.traerFecha("07/06/1997")));
			System.out.println("********64*********"); //total cliente 1 + cliente 2
			System.out.println(s1.calcularTotal(f.traerFecha("06/06/1997"),f.traerFecha("18/06/1997"))); 
			System.out.println("********65*********"); //calculo total en un dia en especial
			System.out.println(s1.calcularTotal(f.traerFecha("06/06/1997")));
			System.out.println(s1.calcularTotal(f.traerFecha("16/06/1997")));
			System.out.println(s1.calcularTotal(f.traerFecha("17/06/1997"))); //no hay carritos en esta fecha
			System.out.println("********66*********"); //calculo total con mes valido
			System.out.println(s1.calcularTotal(06,1997)); 
			System.out.println("********67*********"); //calculo total con mes invalido
			System.out.println(s1.calcularTotal(13,1997));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			Funciones f = new Funciones();
			System.out.println("********68*********"); //calculo total entre fechas de cliente 1
			System.out.println(s1.calcularTotal(f.traerFecha("15/06/1997"),f.traerFecha("18/06/1997"),s1.getAdmCliente().traerCliente(1)));
			System.out.println("********69*********"); //calculo total entre fechas de cliente 2, no hizo compras
			System.out.println(s1.calcularTotal(f.traerFecha("15/06/1997"),f.traerFecha("18/06/1997"),s1.getAdmCliente().traerCliente(2)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			Funciones f = new Funciones();
			System.out.println("********70*********"); //calculo total de cliente que no existe, lanza excepcion
			System.out.println(s1.calcularTotal(f.traerFecha("15/06/1997"),f.traerFecha("18/06/1997"),s1.getAdmCliente().traerCliente(3)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try{
			Funciones f = new Funciones();
			System.out.println("********71*********"); //calculo total de cliente 2 en tal fecha
			System.out.println(s1.calcularTotal(f.traerFecha("06/06/1997"),s1.getAdmCliente().traerCliente(2)));
			System.out.println("********72*********"); //calculo total de cliente 2 en fecha donde no compro
			System.out.println(s1.calcularTotal(f.traerFecha("10/06/1997"),s1.getAdmCliente().traerCliente(2)));
			System.out.println("********73*********"); //calculo total de cliente inexistente
			System.out.println(s1.calcularTotal(f.traerFecha("06/06/1997"),s1.getAdmCliente().traerCliente(3)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		
		try{
			System.out.println("********74*********"); //calculo total de cliente 2 con mes valido
			System.out.println(s1.calcularTotal(06,1997,s1.getAdmCliente().traerCliente(2))); 
			System.out.println("********75*********"); //calculo total de cliente 2 en fecha donde no compro
			System.out.println(s1.calcularTotal(07,1997,s1.getAdmCliente().traerCliente(2)));
			System.out.println("********76*********"); //calculo total con mes invalido
			System.out.println(s1.calcularTotal(13,1997,s1.getAdmCliente().traerCliente(2)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		
		try{
			System.out.println("********77*********"); //calculo total con cliente inexistente
			System.out.println(s1.calcularTotal(07,1997,s1.getAdmCliente().traerCliente(4)));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		
		try{
			System.out.println("********78*********"); //calculo total con dni de cliente 1
			System.out.println(s1.calcularTotal(06,1997,40423033));
			System.out.println("********79*********"); //calculo total con dni de cliente 2
			System.out.println(s1.calcularTotal(06,1997,38412879));
			System.out.println("********80*********"); //calculo total con dni inexistente
			System.out.println(s1.calcularTotal(06,1997,65874));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		
		try{
			System.out.println("********81*********"); //calculo total con fecha invalida
			System.out.println(s1.calcularTotal(13,1997,38412879));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
	}
}

