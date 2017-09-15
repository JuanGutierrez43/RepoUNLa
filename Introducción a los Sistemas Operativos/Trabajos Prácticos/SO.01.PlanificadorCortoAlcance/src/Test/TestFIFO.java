/*------------------------- Algoritmo FIFO-------------------------*/
//  Planificador de corto alcance (PCA)
//
// Es el principal planificador del Sistema Operativo, está continuamente 
// funcionando, es quien decide que proceso pasa a ejecutado, usa distintas 
// políticas o algoritmos, brinda cierta equidad.
// v1.0
// Autor: José Victor Ibáñez
/*------------------------- ------------- -------------------------*/

package Test;

import Model.admProcesamiento;
import Model.Proceso.Prioridad;

public class TestFIFO {

	public static void main(String[] args) {

		// admProcesamiento(int cantidadFilas, int cantidaColumnas)
		admProcesamiento admP = new admProcesamiento(20, 40);

		System.out.println("-----------Creando-----------");

		// agregarProceso(String proceso, int comienzaTiempo, int iCPU, int eyS, int fCPU,Prioridad prioridad)
		admP.agregarProceso("P1", 1, 3, 1, 2, Prioridad.Media);
		admP.agregarProceso("P2", 2, 3, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P3", 3, 4, 2, 5, Prioridad.Alta);
		admP.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);
		admP.agregarProceso("P5", 7, 4, 5, 5, Prioridad.Alta);
		admP.agregarProceso("P6", 8, 1, 3, 1, Prioridad.Media);

		//mostrarAlgoritmoFIFO() politica que ordena de acuerdo al orden de llegada
		System.out.println(admP.mostrarAlgoritmoFIFO());

	}

}
