package ar.edu.utn.link.correlativas.app;

public class AlumnoRepetidoException extends Exception {

	
	
	private String nombre;

	public AlumnoRepetidoException(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
