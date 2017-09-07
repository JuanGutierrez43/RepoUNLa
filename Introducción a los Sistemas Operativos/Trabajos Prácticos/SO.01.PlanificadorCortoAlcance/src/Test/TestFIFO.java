package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class TestFIFO {

	public static void main(String[] args) {

		// public admProcesamiento(int cantidadFilas, int cantidaColumnas)
		admProcesamiento admP = new admProcesamiento(8, 40);

		System.out.println("-----------Creando-----------");

		admP.agregarProceso("P1", 1, 3, 1, 4, Prioridad.Media);
		admP.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P3", 4, 4, 2, 5, Prioridad.Alta);
		admP.agregarProceso("P4", 6, 1, 6, 1, Prioridad.Media);
		admP.agregarProceso("P5", 7, 4, 5, 5, Prioridad.Alta);
		admP.agregarProceso("P6", 8, 1, 3, 1, Prioridad.Media);

		// System.out.println("Ejercicio clase 28/8/2017");
		System.out.println(admP.mostrarAlgoritmoFIFO());
		System.out.println(admP.mostrarLstProceso());
	}

}
