package test;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.Funciones;

public class TestFunciones {

	public static void main(String[] args) {
		GregorianCalendar fecha = new GregorianCalendar();
		System.out.println(Funciones.esBisiesto(1996));
		System.out.println(Funciones.traerAnio(fecha));
		System.out.println(Funciones.traerMes(fecha));
		System.out.println(Funciones.traerDia(fecha));
		System.out.println(Funciones.esFechaValida(1997, 04, 20));
		System.out.println(Funciones.traerFecha(1997, 04, 26));
		System.out.println(Funciones.traerFecha("20/04/1997"));
		System.out.println(Funciones.traerFechaCorta(Funciones.traerFecha("20/04/1997")));
		System.out.println(Funciones.traerFechaCortaHora(fecha));
		System.out.println(Funciones.traerFechaCorta(Funciones.traerFechaProximo(fecha, 2)));
		System.out.println(Funciones.esDiaHabil(fecha));
		System.out.println(Funciones.traerDiaDeLaSemana(fecha));
		System.out.println(Funciones.traerMesEnLetras(fecha));
	}

}
