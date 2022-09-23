package ar.edu.utn.link.correlativas.app;

public class AlumnoRepetidoException extends Throwable {

    private String nombreAlumno;

    public AlumnoRepetidoException(String nombre) {
        super();
        nombreAlumno = nombre;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombre){
        this.nombreAlumno = nombre;
    }
}
