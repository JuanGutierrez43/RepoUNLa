package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
	public static int traerAnio(GregorianCalendar f) {
		return f.get(Calendar.YEAR);
	}

	public static boolean esBisiesto(int anio) {
		if (anio % 4 == 0) {
			if (anio % 100 == 0 || anio % 400 != 0) {
				return true;
			}
		}
		return false;
	}

	public static int traerMes(GregorianCalendar f) {
		return f.get(Calendar.MONTH) + 1;
	}

	public static int traerDia(GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_MONTH);
	}

	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean resu = false;
		switch (mes) {
		case 1:
			if (dia >= 1 && dia <= 31)
				resu = true;
			break;
		case 2:
			if (esBisiesto(anio) && dia >= 1 && dia <= 29) {
				resu = true;
			} else if (!esBisiesto(anio) && dia >= 1 && dia <= 28) {
				resu = true;
			}
			break;
		case 3:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		case 4:
			if (dia >= 1 && dia <= 30) {
				resu = true;
				break;
			}
		case 5:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		case 6:
			if (dia >= 1 && dia <= 30) {
				resu = true;
				break;
			}
		case 7:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		case 8:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		case 9:
			if (dia >= 1 && dia <= 30) {
				resu = true;
				break;
			}
		case 10:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		case 11:
			if (dia >= 1 && dia <= 30) {
				resu = true;
				break;
			}
		case 12:
			if (dia >= 1 && dia <= 31) {
				resu = true;
				break;
			}
		default:
			resu = false;
			break;
		}
		return resu;
	}

	public static GregorianCalendar traerFecha(int anio, int mes, int dia) {
		GregorianCalendar fecha = new GregorianCalendar();
		if (esFechaValida(anio, mes, dia)) {
			fecha.set(anio, mes - 1, dia);
		} else {
			fecha = null;
		}
		return fecha;
	}

	public static GregorianCalendar traerFecha(String fecha) {
		return traerFecha(Integer.parseInt(fecha.substring(6, 10)), Integer.parseInt(fecha.substring(3, 5)),
				Integer.parseInt(fecha.substring(0, 2)));
	}

	public static String traerFechaCorta(GregorianCalendar f) {
		String fechaCorta;
		if (traerDia(f) < 10) {
			fechaCorta = "0" + traerDia(f) + "/";
		} else {
			fechaCorta = traerDia(f) + "/";
		}
		if (traerMes(f) < 10) {
			fechaCorta = fechaCorta + "0" + traerMes(f) + "/";
		} else {
			fechaCorta = fechaCorta + traerMes(f) + "/";
		}

		return fechaCorta + traerAnio(f);
	}

	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		String traerFechaCortaHora = traerFechaCorta(fecha) + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":"
				+ fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND);
		return traerFechaCortaHora;
	}

	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {
		int anio = Funciones.traerAnio(fecha);
		int mes = Funciones.traerMes(fecha);
		int dia = Funciones.traerDia(fecha);
		GregorianCalendar fechaProximo = new GregorianCalendar(anio, mes, dia);
		fechaProximo.add(Calendar.DATE, cantDias);
		return fechaProximo;
	}

	public static boolean esDiaHabil(GregorianCalendar fecha) {
		boolean esHabil = true;
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		if (dia > 4)
			esHabil = false;
		return esHabil;
	}

	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		String day = " ";
		switch (dia) {
		case 2: {
			day = "lunes";
			break;
		}
		case 3: {
			day = "martes";
			break;
		}
		case 4: {
			day = "miercoles";
			break;
		}
		case 5: {
			day = "jueves";
			break;
		}
		case 6: {
			day = "viernes";
			break;
		}
		case 7: {
			day = "sabado";
			break;
		}
		case 1: {
			day = "domingo";
			break;
		}
		}
		return day;
	}

	public static String traerMesEnLetras(GregorianCalendar fecha) {
		int mes = fecha.get(Calendar.MONTH);
		String month = " ";
		switch (mes) {
		case 0: {
			month = "enero";
			break;
		}
		case 1: {
			month = "febrero";
			break;
		}
		case 2: {
			month = "marzo";
			break;
		}
		case 3: {
			month = "abril";
			break;
		}
		case 4: {
			month = "mayo";
			break;
		}
		case 5: {
			month = "junio";
			break;
		}
		case 6: {
			month = "julio";
			break;
		}
		case 7: {
			month = "agosto";
			break;
		}
		case 8: {
			month = "septiembre";
			break;
		}
		case 9: {
			month = "octubre";
			break;
		}
		case 10: {
			month = "noviembre";
			break;
		}
		case 11: {
			month = "diciembre";
			break;
		}
		}
		return month;
	}

	public static String traerFechaLarga(GregorianCalendar fecha) {
		return traerDiaDeLaSemana(fecha) + " " + traerDia(fecha) + " de " + traerMesEnLetras(fecha) + " del "
				+ traerAnio(fecha);
	}

	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		boolean resu = false;
		if (traerAnio(fecha) == traerAnio(fecha1) && traerMes(fecha) == traerMes(fecha1)
				&& traerDia(fecha) == traerDia(fecha1)) {
			resu = true;
		}
		return resu;
	}

	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		boolean resu = false;
		if (traerAnio(fecha) == traerAnio(fecha1) && traerMes(fecha) == traerMes(fecha1)
				&& traerDia(fecha) == traerDia(fecha1) && traerHora(fecha) == traerHora(fecha1)
				&& traerMin(fecha) == traerMin(fecha1) && traerSeg(fecha) == traerSeg(fecha1)) {
			resu = true;
		}
		return resu;
	}// para poder hacer esta comparacion necesito traer las horas,minutos y
		// segundos

	public static int traerHora(GregorianCalendar fecha) {
		return fecha.get(Calendar.HOUR_OF_DAY);
	}

	public static int traerMin(GregorianCalendar fecha) {
		return fecha.get(Calendar.MINUTE);
	}

	public static int traerSeg(GregorianCalendar fecha) {
		return fecha.get(Calendar.SECOND);
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int dias = 0;
		switch (mes) {
		case 1: {
			dias = 31;
			break;
		}
		case 2: {
			if (esBisiesto(anio)) {
				dias = 29;
			} else
				dias = 28;
			break;
		}
		case 3: {
			dias = 31;
			break;
		}
		case 4: {
			dias = 30;
			break;
		}
		case 5: {
			dias = 31;
			break;
		}
		case 6: {
			dias = 30;
			break;
		}
		case 7: {
			dias = 31;
			break;
		}
		case 8: {
			dias = 31;
			break;
		}
		case 9: {
			dias = 30;
			break;
		}
		case 10: {
			dias = 31;
			break;
		}
		case 11: {
			dias = 30;
			break;
		}
		case 12: {
			dias = 31;
			break;
		}
		}
		return dias;
	}

	public static double aproximar2Decimal(double valor) {
		return Math.rint(valor * 100) / 100;
	}

	public static boolean esNumero(char c) {
		boolean esNum = Character.isDigit(c);
		return esNum;
	}

	public static boolean esCaracter(char c) {
		boolean esAlfabeto = Character.isAlphabetic(c);
		return esAlfabeto;
	}

	public static boolean esCadenaNros(String cadena) {
		boolean esCadena = true;
		int i = 0;
		char c;
		while (i < cadena.length()) {
			c = cadena.charAt(i);
			if (!Funciones.esNumero(c)) {
				esCadena = false;
				i = cadena.length();
			}
			i++;
		}
		return esCadena;
	}

	public static boolean esCandenaLetras(String cadena) {
		boolean esCadena = true;
		int i = 0;
		char c;
		while (i < cadena.length()) {
			c = cadena.charAt(i);
			if (!Funciones.esCaracter(c)) {
				esCadena = false;
				i = cadena.length();
			}
			i++;
		}
		return esCadena;
	}

	public static double convertirADouble(int n) {
		return ((double) n);
	}
		
	public static boolean esFechaMenor(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		boolean antes=false;
		if (fechaInicio.getTimeInMillis()<=fechaFin.getTimeInMillis()){
			antes = true;
		}
		return antes;
	}
	
	public static boolean esFechaMayor(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		boolean despues=false;
		if (fechaInicio.getTimeInMillis()>=fechaFin.getTimeInMillis()){
			despues = true;
		}
		return despues;
	}
}