package modelo;

import java.util.Arrays;

public class ArregloUnidimensional {

	int[] vector;

	public ArregloUnidimensional(int[] vector) {
		this.vector = vector;
	}

	public int[] getVector() {
		return vector;
	}

	public void setVector(int[] vector) {
		this.vector = vector;
	}

	// Metodos
	public int traerElMenor() {
		int resultado = vector[0];
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] < resultado) {
				resultado = vector[i];
			}
		}
		return resultado;
	}

	public int traerElMayor() {
		int resultado = vector[0];
		for (int i = 1; i < vector.length; i++) {
			if (vector[i] > resultado) {
				resultado = vector[i];
			}
		}
		return resultado;
	}

	public double calcularPromedio() {
		double promedio = 0;
		for (int i = 0; i < vector.length; i++) {
			promedio += vector[i];
		}
		promedio = promedio / vector.length;

		return promedio;
	}

	public int[] ordenarAscendente() {
		int i, j, aux;
		int lon = vector.length;
		int[] auxiliarvec = new int[lon];
		for (int x = 0; x < lon; x++) {
			auxiliarvec[x] = vector[x];
		}
		for (i = 0; i < auxiliarvec.length - 1; i++) {
			for (j = 0; j < auxiliarvec.length - 1; j++) {
				if (auxiliarvec[j + 1] < auxiliarvec[j]) {
					aux = auxiliarvec[j + 1];
					auxiliarvec[j + 1] = auxiliarvec[j];
					auxiliarvec[j] = aux;

				}
			}
		}
		return auxiliarvec;
	}

	public int[] ordenarDescendente() {
		int i, j, aux;
		int lon = vector.length;
		int[] auxiliarvec = new int[lon];
		for (int x = 0; x < lon; x++) {
			auxiliarvec[x] = vector[x];
		}
		for (i = 0; i < auxiliarvec.length - 1; i++) {
			for (j = 0; j < auxiliarvec.length - 1; j++) {
				if (auxiliarvec[j + 1] > auxiliarvec[j]) {
					aux = auxiliarvec[j + 1];
					auxiliarvec[j + 1] = auxiliarvec[j];
					auxiliarvec[j] = aux;

				}
			}
		}
		return auxiliarvec;
	}

	public double traerFrecuencia(int numero) {
		int i;
		double vcontar = 0;
		double resultado = 0;
		for (i = 0; i < vector.length; i++) {
			if (vector[i] == numero) {
				vcontar++;

			}
		}
		resultado = (vcontar / (vector.length));
		return resultado;
	}

	@Override
	public String toString() {
		return Arrays.toString(vector);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(vector);
		return result;
	}

//	public boolean equal(int id){
//		boolean validate =false;
//		if (id==0) {
//			validate=true;
//		}
//		return validate;
//	}
	
	public int traerModa() {
		double auxfrec=0;
		int mayor =0;
		for (int i = 0; i < vector.length; i++) {
			if (this.traerFrecuencia(vector[i])>auxfrec) {
				auxfrec=traerFrecuencia(vector[i]);
				mayor=vector[i];

			}
		}
		return mayor;
	}
}
