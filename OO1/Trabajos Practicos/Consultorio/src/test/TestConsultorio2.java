package test;

import consultorio.Paciente;
import consultorio.Medico;
public class TestConsultorio2 {

	public static void main(String[] args) {

		Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Fernández", 1.60f, 90);
		Medico medico1= new Medico("Daniel","Lopez","Clinico");
		System.out.println("Visita 1");
		System.out.println("Medico: "+medico1.traerNombreCompleto());
		System.out.println("Paciente "+paciente1.traerNombreCompleto()+": IMC "+medico1.calcularIMC(paciente1));
		System.out.println("Paciente "+paciente2.traerNombreCompleto()+": IMC "+medico1.calcularIMC(paciente2)+"\n");
		System.out.println("Visita 2");
		System.out.println("Medico: "+medico1.traerNombreCompleto());
		System.out.println("Paciente "+paciente2.traerNombreCompleto()+": IMC "+medico1.calcularIMC(paciente2));
	}

}
