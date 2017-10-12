package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class TestTP2Simulación {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// *****************************************************************************
		admProcesamiento admP3 = new admProcesamiento(8, 50);
		System.out.println("-----------Creando-----------");

		// agregarProceso():
		admP3.agregarProceso("P1", 1, 4, 2, 3, Prioridad.Alta);
		admP3.agregarProceso("P2", 1, 3, 4, 3, Prioridad.Baja);
		admP3.agregarProceso("P3", 2, 2, 2, 6, Prioridad.Alta);
		admP3.agregarProceso("P4", 3, 1, 3, 2, Prioridad.Media);
		admP3.agregarProceso("P5", 4, 1, 1, 5, Prioridad.Media);
		admP3.agregarProceso("P6", 5, 4, 1, 3, Prioridad.Baja);
		admP3.agregarProceso("P7", 5, 5, 2, 1, Prioridad.Media);
		admP3.agregarProceso("P8", 7, 1, 3, 1, Prioridad.Baja);

		// mostrarAlgoritmos():
		//System.out.println(admP3.mostrarAlgoritmoFIFO());
		System.out.println(admP3.mostrarAlgoritmoPrioridad());
		//System.out.println(admP3.mostrarAlgoritmoSPN());
		System.out.println(admP3.mostrarAlgoritmoPrioridadSPN());
		
		

	}

}
