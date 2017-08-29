package test;
import java.util.Arrays;

import modelo.ArregloUnidimensional;
public class ArregloUnidimensionalTest {

	public static void main(String[] args) {
		int [] vector = {5, 5, 10, 3, 4, 6};
		ArregloUnidimensional vec = new ArregloUnidimensional (vector);
		System.out.println("Mayor: " + vec.traerElMenor());
		System.out.println("Menor: " + vec.traerElMayor());
		System.out.println("Promedio: " + vec.calcularPromedio());
		System.out.println("Vector original: " + vec);
		System.out.println("Vector Ordenado ascendentemente: " + Arrays.toString(vec.ordenarAscendente()));
		System.out.println("Vector original: " + vec);
		System.out.println("Vector ordenado descendentemente: " + Arrays.toString(vec.ordenarDescendente()));
		System.out.println("Vector original: " + vec);
		int numero = 5;
		System.out.println("Frecuencia de "+numero+": "+vec.traerFrecuencia(numero));
		System.out.println("Moda: " +vec.traerModa());
		
		
	}

}
