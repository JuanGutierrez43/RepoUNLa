package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {

	public static boolean esBisiesto (int anio){
		boolean resultado = false;
		if (anio%4==0 && ((anio % 100 != 0) || (anio % 400 == 0))){
			resultado= true;
		}
		return resultado;
	}
	
	public static int traerAnio (GregorianCalendar f){
		return f.get(Calendar.YEAR);
		}
	
	public static int traerMes (GregorianCalendar f){
		return (f.get(Calendar.MONTH))+1;
	}
	
	public static int traerDia (GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia){
	boolean resultado = false;
	if (mes >= 0 && mes <= 11){
		if (dia > 0 && dia < 31){
			resultado = true;
		}
	}
		resultado = true;
		
	if (esBisiesto(anio)==true){
		if (dia==29 && mes==02){
			resultado=true;
		}
	}
	return resultado;
	}
	public static GregorianCalendar traerFecha(int anio, int mes, int dia){
		GregorianCalendar fecha = new GregorianCalendar();
		if(esFechaValida(anio,mes,dia)){
			fecha.set(anio,mes -1, dia);
		}
		else{
			fecha=null;
		}
		return fecha;
	}
	
	public static GregorianCalendar traerFecha(String fecha){
		return traerFecha(Integer.parseInt(fecha.substring(6,10)), Integer.parseInt(fecha.substring(3,5)), Integer.parseInt(fecha.substring(0,2)));
	}
	
	public static String traerFechaCorta(GregorianCalendar f){
		String fechaCorta;
		if (traerDia(f)<10){
			fechaCorta= "0" + traerDia(f) + "/";
		}
		else{
			fechaCorta = traerDia(f) + "/";
		}
		if(traerMes(f)<10){
			fechaCorta= fechaCorta + "0" + traerMes(f) + "/";
		}
		else{
			fechaCorta = fechaCorta + traerMes(f)+ "/";
		}
		return fechaCorta + traerAnio(f);

	}
	
	 public static String traerFechaCortaHora (GregorianCalendar fecha){
		 String traerFechaCortaHora = traerFechaCorta(fecha) + " " + fecha.get(Calendar.HOUR_OF_DAY)+ ":"+ fecha.get(Calendar.MINUTE)+ ":"+ fecha.get(Calendar.SECOND)+ ":"+ fecha.get(Calendar.MILLISECOND);
		 return traerFechaCortaHora;
		 
	 }
	 
	 public static GregorianCalendar traerFechaProximo (GregorianCalendar fecha, int cantDias) {
		GregorianCalendar fechaProximo = new GregorianCalendar (Funciones.traerAnio(fecha),Funciones.traerMes(fecha)-1,Funciones.traerDia(fecha));
		fechaProximo.add(Calendar.DATE, cantDias);
		
		
		 return fechaProximo;
	 }

	
	public static boolean esDiaHabil(GregorianCalendar fecha){
		boolean resultado = true;
		if (fecha.get(Calendar.DAY_OF_WEEK) == 1 || fecha.get(Calendar.DAY_OF_WEEK) == 7 ){
			resultado = false;
		}
		return resultado;
	}
	
	 public static String traerDiaDeLaSemana (GregorianCalendar fecha){
		 return fecha.get(Calendar.DAY_OF_WEEK)+"";
	 }
	 public static String traerMesEnLetras (GregorianCalendar fecha){
		 int mes = fecha.get(Calendar.MONTH);
		 String month= "";
		 switch (mes){
		 case 0: {
			 month = "Enero";
			 break;
		 }
		 case 1: {
			 month = "Febrero";
			 break;
		 }
		 case 2: {
			 month = "Marzo";
			 break;
		 }
		 case 3: {
			 month = "Abril";
			 break;
		 }
		 case 4: {
			 month = "Mayo";
			 break;
		 }
		 case 5: {
			 month = "Junio";
			 break;
		 }
		 case 6: {
			 month = "Julio";
			 break;
		 }
		 case 7: {
			 month = "Agosto";
			 break;
		 }
		 case 8: {
			 month = "Septiembre";
			 break;
		 }
		 case 9: {
			 month = "Octubre";
			 break;
		 }
		 case 10: { 
			 month = "Noviembre";
			 break;
		 }
		 case 11: {
			 month = "Diciembre";
			 break;
		 }
		 }
		 return month;
	 }
}
