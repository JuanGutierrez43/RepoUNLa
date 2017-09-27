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

public class TestTPSimulación {

	public static void main(String[] args) {

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

		// mostrarAlgoritmoFIFO():
		System.out.println(admP3.mostrarAlgoritmoFIFO());
		System.out.println(admP3.mostrarAlgoritmoPrioridad());

		// Propuesta
//		admP3.analizarProceso(admP3.traerProceso(5));
//		
//		
//		// Propuesta
//		admP3.planificarPrioridad(lstProcesosListo, auxTabla).analizarTiempoProceso();
//		admP3.planificarFIFO(lstProcesosListo, auxTabla).analizarTiempoProceso();
//		
//		
//		// Propuesta
//		admP3.planificarPrioridad(lstProcesosListo, auxTabla).analizarBloqueoParalelo();
//		admP3.planificarFIFO(lstProcesosListo, auxTabla).analizarBloqueoParalelo();
//				
	}

}
