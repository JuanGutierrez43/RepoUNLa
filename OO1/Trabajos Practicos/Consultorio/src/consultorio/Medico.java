package consultorio;
import consultorio.Paciente;
public class Medico {
private String nombre;
private String apellido;
private String especialidad;
public Medico(String nombre, String apellido, String especialidad) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.especialidad = especialidad;
}
public String getNombre() {
	return this.nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return this.apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEspecialidad() {
	return this.especialidad;
}
public void setEspecialidad(String especialidad) {
	this.especialidad = especialidad;
}
public float calcularIMC(Paciente paciente){
	float resu;
	return resu=(paciente.getPeso()/(paciente.getEstatura()*paciente.getEstatura()));
}
public String traerNombreCompleto() {
	String resultado;
	resultado = nombre + " " + apellido;
	return resultado;
}
}
