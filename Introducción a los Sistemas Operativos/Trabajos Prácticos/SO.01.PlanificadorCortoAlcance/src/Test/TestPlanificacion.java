package Test;

import Model.Proceso.Prioridad;
import Model.admProcesamiento;

public class TestPlanificacion {
	public static void main(String[] args) {

		admProcesamiento admP = new admProcesamiento(8, 40);

		System.out.println("-----------Creando-----------");

		admP.agregarProceso("P1", 1, 3, 2, 4, Prioridad.Media);
		admP.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		admP.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);
		admP.agregarProceso("P5", 7, 4, 2, 1, Prioridad.Alta);
		admP.agregarProceso("P6", 9, 4, 2, 1, Prioridad.Baja);
		admP.agregarProceso("P7", 10, 4, 2, 1, Prioridad.Alta);
		
		// test 1
		System.out.println("Test 1: " + admP.traerProceso(0));
		System.out.println("\t" + admP.getHilo());// Compruebo
		System.out.println("\t" + admP.getBuffers());// Compruebo

		System.out.println("-----------Ejecutando-----------");
		// test 2
		System.out.println("Test 2: " + admP.ejecutarProceso(admP.traerProceso(0)));
		System.out.println("\t" + admP.getHilo());// Compruebo

		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		admP.getHilo().ejecutarInstrucción();
		System.out.println("\t" + admP.getHilo() + " -> Ejecutado");// Compruebo

		// test3

		System.out.println("Test 3: " + admP.terminarProceso() + " Terminado");
		System.out.println("\t" + admP.getHilo());// Compruebo

		System.out.println("-----------Bloqueado-----------");
		// test4
		System.out.println("Test 4: " + admP.bloquearProceso(admP.traerProceso(0)));
		System.out.println("\t" + admP.bloquearProceso(admP.traerProceso(1)));
		System.out.println("\t" + admP.getBuffers());// Compruebo

		// test5
		System.out.println("Test 5: " + admP.getBuffers().ejecutarEyS(1) + " Ejecutando E/S");
		System.out.println("\t" + admP.getBuffers());// Compruebo
		System.out.println("Test 5: " + admP.getBuffers().ejecutarEyS(1) + " Ejecutando E/S");
		System.out.println("\t" + admP.getBuffers());// Compruebo
		System.out.println("Test 5: " + admP.getBuffers().ejecutarEyS(1) + " Ejecutando E/S");
		System.out.println("\t" + admP.getBuffers());// Compruebo

		// test6
		System.out.println("Test 6: " + admP.desbloquearProceso(1) + " Eliminado");
		System.out.println("\t" + admP.getBuffers());// Compruebo
		System.out.println("Test 6: " + admP.desbloquearProceso(2) + " Eliminado");
		System.out.println("\t" + admP.getBuffers());// Compruebo

		System.out.println("-----------Listo-----------");
		// test7
		System.out.println("Test 7: " + admP.listarProcesoFIFO(admP.traerProceso(0)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(1)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(2)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(3)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(4)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(5)));
		System.out.println("\t" + admP.listarProcesoFIFO(admP.traerProceso(6)));
		
		System.out.println("\t" + admP.getListo());// Compruebo

		// test8 nuevo¡¡¡
		System.out.println("Test 8: " + admP.getListo().ordenarPrioridad() + " Ordenando");
		System.out.println("\t" + admP.getListo());// Compruebo

		// test9
		System.out.println("Test 9: " + admP.deslistarProcesoFIFO() + " Ejecutando");
		System.out.println("\t" + admP.getListo());// Compruebo
		admP.deslistarProcesoFIFO();
		System.out.println("\t" + admP.getListo());// Compruebo

	}

}
