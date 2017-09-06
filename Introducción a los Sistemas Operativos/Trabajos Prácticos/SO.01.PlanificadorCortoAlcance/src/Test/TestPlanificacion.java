package Test;

import Model.Proceso.Prioridad;
import Model.admProcesamiento;

public class TestPlanificacion {
	public static void main(String[] args) {

		// Clase 28/08/2017
		admProcesamiento admP = new admProcesamiento(8, 40);
		
		admP.agregarProceso("P1", 1, 3, 2, 4, Prioridad.Media);
		admP.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		admP.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);
		//admP.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		
		System.out.println("Ejercicio clase 28/8/2017");
		System.out.println(admP.mostrarAlgoritmoFIFO());

//		admP.agregarProceso("P5", 8, 3, 2, 2, Prioridad.Baja);
//		admP.agregarProceso("P6", 12, 1, 3, 4, Prioridad.Media);
//		admP.agregarProceso("P7", 15, 2, 4, 1, Prioridad.Alta);
//		admP.agregarProceso("P8", 15, 2, 4, 1, Prioridad.Alta);
//		System.out.println(admP.mostrarAlgoritmoFIFO());

		// TP
		admProcesamiento admP3 = new admProcesamiento(10, 30);

		admP3.agregarProceso("P1", 1, 4, 3, 3, Prioridad.Alta);
		admP3.agregarProceso("P2", 1, 2, 4, 3, Prioridad.Baja);
		admP3.agregarProceso("P3", 3, 2, 5, 1, Prioridad.Media);
		admP3.agregarProceso("P4", 3, 1, 4, 5, Prioridad.Media);
		admP3.agregarProceso("P5", 5, 3, 2, 3, Prioridad.Alta);

//		System.out.println("Ejercicio 1 Guía");
//		System.out.println(admP3.mostrarAlgoritmoFIFO());

		// cambia pranificarFIFO() los atributos originales de los objetos
		// 1.A
		admProcesamiento admP4 = new admProcesamiento(10, 30);

		admP4.agregarProceso("P1", 1, 4, 3, 3, Prioridad.Alta);
		admP4.agregarProceso("P2", 1, 2, 4, 3, Prioridad.Baja);
		admP4.agregarProceso("P3", 3, 2, 5, 1, Prioridad.Media);
		admP4.agregarProceso("P4", 3, 1, 4, 5, Prioridad.Media);
		admP4.agregarProceso("P5", 5, 3, 2, 3, Prioridad.Alta);
		
		// System.out.println(admP4.toString(admP4.pranificarPrioridad()));

	}

}
