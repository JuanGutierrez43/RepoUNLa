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

		//*****************************************************************************
		//-Prueba numero 1 del algoritmo FIFO
		
		//admProcesamiento(int cantidadFilas, int cantidaColumnas)
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
		
		//*****************************************************************************
		//-Prueba numero 2 del algoritmo FIFO
		admProcesamiento admP2 = new admProcesamiento (8, 50);
		System.out.println("/-----------Creando 2-----------");

		//agregarProceso:
		admP2.agregarProceso("P1", 1, 1, 3, 2, Prioridad.Alta);
		admP2.agregarProceso("P2", 1, 5, 2, 4, Prioridad.Baja);
		admP2.agregarProceso("P3", 2, 4, 1, 6, Prioridad.Alta);
		admP2.agregarProceso("P4", 3, 5, 1, 1, Prioridad.Media);
		admP2.agregarProceso("P5", 3, 3, 4, 1, Prioridad.Media);
		admP2.agregarProceso("P6", 5, 1, 2, 3, Prioridad.Baja);
		admP2.agregarProceso("P6", 6, 4, 3, 1, Prioridad.Media);
		admP2.agregarProceso("P8", 8, 2, 5, 1, Prioridad.Baja);
		
		//mostrarAlgoritmoFIFO():
		System.out.println(admP2.mostrarAlgoritmoFIFO());

		//*****************************************************************************
		//-Prueba numero 3 del algoritmo FIFO
		admProcesamiento admP3 = new admProcesamiento (8, 50);
		System.out.println("/-----------Creando 3-----------");

		//agregarProceso:
		admP3.agregarProceso("P1", 1, 4, 2, 3, Prioridad.Alta);
		admP3.agregarProceso("P2", 1, 3, 4, 3, Prioridad.Baja);
		admP3.agregarProceso("P3", 2, 2, 2, 6, Prioridad.Alta);
		admP3.agregarProceso("P4", 3, 1, 3, 2, Prioridad.Media);
		admP3.agregarProceso("P5", 4, 1, 1, 5, Prioridad.Media);
		admP3.agregarProceso("P6", 5, 4, 1, 3, Prioridad.Baja);
		admP3.agregarProceso("P6", 5, 5, 2, 1, Prioridad.Media);
		admP3.agregarProceso("P8", 7, 1, 3, 1, Prioridad.Baja);



		//mostrarAlgoritmoFIFO():
		System.out.println(admP3.mostrarAlgoritmoFIFO());
	}

}
