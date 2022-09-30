package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepoAlumno {

    public void save(Alumno a) throws AlumnoRepetidoException;

    Page<Alumno> page(Pageable page);

    public List<Alumno> all();

    public Alumno porNombre(String nombre);

}
