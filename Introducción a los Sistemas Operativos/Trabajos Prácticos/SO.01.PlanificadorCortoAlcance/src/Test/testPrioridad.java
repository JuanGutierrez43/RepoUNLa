package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class testPrioridad {

	public static void main(String[] args) {
		
		// admProcesamiento(int cantidadFilas, int cantidaColumnas)
		admProcesamiento admP = new admProcesamiento(10, 40);

		System.out.println("-----------Creando-----------");

		// agregarProceso(String proceso, int comienzaTiempo, int iCPU, int eyS, int fCPU,Prioridad prioridad)
		admP.agregarProceso("P1", 1, 4, 3, 3, Prioridad.Alta);
		admP.agregarProceso("P2", 2, 2, 4, 3, Prioridad.Baja);
//		admP.agregarProceso("P3", 3, 2, 5, 1, Prioridad.Media);
//		admP.agregarProceso("P4", 3, 1, 4, 5, Prioridad.Media);
		admP.agregarProceso("P5", 5, 3, 2, 3, Prioridad.Alta);
//		
		//mostrarAlgoritmoPrioridad() politica que ordena de acuerdo a la prioridad
		System.out.println(admP.mostrarAlgoritmoPrioridad());
		
	}

}
