package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class TestFIFO {

	public static void main(String[] args) {

		// admProcesamiento(int cantidadFilas, int cantidaColumnas)
		admProcesamiento admP = new admProcesamiento(30, 100);

		System.out.println("-----------Creando-----------");

		// agregarProceso(String proceso, int comienzaTiempo, int iCPU, int eyS, int fCPU,Prioridad prioridad)
		admP.agregarProceso("P1", 1, 3, 1, 4, Prioridad.Media);
		admP.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P3", 4, 4, 20, 5, Prioridad.Alta);
		admP.agregarProceso("P4", 6, 1, 10, 1, Prioridad.Media);
		admP.agregarProceso("P5", 7, 4, 5, 5, Prioridad.Alta);
		admP.agregarProceso("P6", 8, 1, 3, 1, Prioridad.Media);
		admP.agregarProceso("P7", 10, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P8", 11, 4, 20, 5, Prioridad.Alta);
		admP.agregarProceso("P9", 12, 1, 10, 1, Prioridad.Media);
		admP.agregarProceso("P10", 13, 4, 5, 5, Prioridad.Alta);
		admP.agregarProceso("P11", 14, 1, 3, 1, Prioridad.Media);
		admP.agregarProceso("P12", 16, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P13", 20, 4, 20, 5, Prioridad.Alta);
		admP.agregarProceso("P14", 25, 1, 10, 1, Prioridad.Media);
		admP.agregarProceso("P15", 26, 4, 5, 5, Prioridad.Alta);
		admP.agregarProceso("P16", 30, 1, 3, 1, Prioridad.Media);

		System.out.println(admP.mostrarAlgoritmoFIFO());
	}

}
