package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class TestTP2Simulación {

	public static void main(String[] args) {

		// *****************************************************************************
		admProcesamiento admP3 = new admProcesamiento(8, 33);
		System.out.println("-----------Creando-----------");

		admP3.agregarProceso("P1", 1, 4, 3, 3, Prioridad.Alta);
		admP3.agregarProceso("P2", 1, 2, 4, 3, Prioridad.Baja);
		admP3.agregarProceso("P3", 3, 2, 5, 1, Prioridad.Media);
		admP3.agregarProceso("P4", 3, 1, 4, 5, Prioridad.Media);
		admP3.agregarProceso("P5", 5, 3, 2, 3, Prioridad.Alta);
		
		System.out.println(admP3.mostrarAlgoritmoPrioridad());
		System.out.println(admP3.mostrarAlgoritmoPrioridadSPN());
		

	}

}
