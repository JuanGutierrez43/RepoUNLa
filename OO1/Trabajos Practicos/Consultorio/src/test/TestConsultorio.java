package test;

import consultorio.Paciente;

public class TestConsultorio {

	public static void main(String[] args) {

		Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Fernández", 1.60f, 90);
		System.out.println("Pacientes:");
		System.out.println(paciente1.traerNombreCompleto());
		System.out.println(paciente2.traerNombreCompleto());
	}

}


