package ar.edu.utn.link.correlativas.app;

public class MateriaRepetidaException extends Throwable {

    private String nombreMateria;

    public MateriaRepetidaException(String nombre) {
        super();
        nombreMateria = nombre;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombre){
        this.nombreMateria=nombre;
    }
}
