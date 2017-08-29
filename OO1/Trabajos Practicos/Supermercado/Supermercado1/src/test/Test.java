package test;
import modelo.Supermercado;
import modelo.Producto;
import modelo.ItemCarrito;
import modelo.Carrito;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		Supermercado s1 = new Supermercado();
		try {
			System.out.println("********1*********"); //agrego producto
			System.out.println(s1.agregarProducto("Manteca",30));
			System.out.println("********2*********"); //agrego producto, pero ya esta ingresado, tira excepcion
			System.out.println(s1.agregarProducto("Manteca",30));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		try {
			System.out.println("********3*********"); //agrego producto
			System.out.println(s1.agregarProducto("Leche",25));
			System.out.println(s1.agregarProducto("Alfajor",20));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********4*********"); //traigo producto por String
		System.out.println(s1.traerProducto("Manteca"));
		System.out.println("********5*********"); //traigo producto, como no existe devuelve null
		System.out.println(s1.traerProducto("Dulce de Leche"));
		System.out.println("********6*********"); //traigo producto por String
		System.out.println(s1.traerProducto("Leche"));
		System.out.println("********7*********"); //traigo producto por String
		System.out.println(s1.traerProducto("Alfajor"));
		System.out.println("********8*********"); //traigo producto por id
		System.out.println(s1.traerProducto(1));
		System.out.println("********9*********"); //traigo producto por id
		System.out.println(s1.traerProducto(2));
		System.out.println("********10*********"); //traigo producto por id
		System.out.println(s1.traerProducto(3));
		System.out.println("********11*********"); //traigo producto, como no existe devuelve null
		System.out.println(s1.traerProducto(4));
		try {
			System.out.println("********12*********");//modifico Alfajor por Dulce de leche
			System.out.println(s1.modificarProducto(3,"Dulce de leche",70));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("********13*********"); //traigo el producto que modifique
		System.out.println(s1.traerProducto(3));
		try {
			System.out.println("********14*********"); //modifico producto, como no existe tira excepcion
			System.out.println(s1.modificarProducto(5,"Turron",8));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("********15*********"); //agrego producto
			System.out.println(s1.agregarProducto("Barra",12));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********16*********"); //traigo producto
		System.out.println(s1.traerProducto("Barra"));
		try {
			System.out.println("********17*********"); //elimino producto
			System.out.println(s1.eliminarProducto(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********18*********"); //traigo producto que elimine, devuelve null
		System.out.println(s1.traerProducto(4));
		try {
			System.out.println("********19*********"); //elimino producto, como no existe tiro excepcion
			System.out.println(s1.eliminarProducto(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		Carrito c1 = new Carrito();
		System.out.println("********20*********"); //agrego item manteca
		System.out.println(c1.agregarItem(s1.traerProducto(1),2));
		System.out.println("********21*********"); //traigo item 1
		System.out.println(c1.traerItemCarrito(1));
		System.out.println("********22*********"); //agrego item manteca, se le suma la cantidad
		System.out.println(c1.agregarItem(s1.traerProducto(1),2));
		System.out.println("********23*********"); //traigo item 1 con mas cantidad
		System.out.println(c1.traerItemCarrito(1));
		System.out.println("********24*********"); //traigo producto para ver cual es y agregarlo
		System.out.println(s1.traerProducto(2)); 
		System.out.println("********25*********"); //agrego item leche
		System.out.println(c1.agregarItem(s1.traerProducto(2),5));
		System.out.println("********26*********"); //traigo item 2
		System.out.println(c1.traerItemCarrito(2)); 
		try {
			System.out.println("********27*********"); //resto cantidad de item 2
			System.out.println(c1.eliminarItem(s1.traerProducto(2),3));
			System.out.println("********28*********");//traigo item 2
			System.out.println(c1.traerItemCarrito(2)); 
			System.out.println("********29*********"); //elimino item 2
			System.out.println(c1.eliminarItem(s1.traerProducto(2),2));
			System.out.println("********30*********");//traigo item 2, devuelve null porque ya no existe
			System.out.println(c1.traerItemCarrito(2)); 
			System.out.println("********31*********"); //elimino item, como no existe tiro excepcion
			System.out.println(c1.eliminarItem(s1.traerProducto(3),5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace()
		}
		System.out.println("********32*********"); //calculo subtotal 4 mantecas * 30 = 120
		System.out.println(c1.traerItemCarrito(1).calcularSubTotal()); 
		System.out.println("********33*********"); //traigo producto 3
		System.out.println(s1.traerProducto(3));
		System.out.println("********34*********"); //agrego dulce de leche
		System.out.println(c1.agregarItem(s1.traerProducto(3),5));
		System.out.println("********35*********"); //calculo total (4 mantecas * 30)+(5 dulce de leche * 70)= 120+350 = 470
		System.out.println(c1.calcularTotal());
	}	
}
