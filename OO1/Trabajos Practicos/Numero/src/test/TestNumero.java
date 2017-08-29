package test;
import modelo.Numero;
public class TestNumero{
	public static void main(String[] args) {
		Numero n1= new Numero (0);
		System.out.println(n1.sumar(5));
		System.out.println(n1.multiplicar(2));
		System.out.println(n1.esPar());
		System.out.println(n1.esPrimo());
		System.out.println(n1.convertirAString());
		System.out.println(n1.convertirDouble());
		System.out.println(n1.calcularPotencia(3));
		System.out.println(n1.pasarBase2());
		System.out.println("Factorial: "+n1.calcularFactorial());
		System.out.println("Combinatoria: "+n1.numeroCombinatorio(3));
	}

}
