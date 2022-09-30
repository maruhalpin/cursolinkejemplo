package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoAlumnoMemoria implements RepoAlumno{

    private List<Alumno> alumnos;

    public RepoAlumnoMemoria(){
        super();
        this.alumnos = new ArrayList<>();
    }

    @Override
    public void save(Alumno a) throws AlumnoRepetidoException{
        if(this.existeAlumnoDeNombre(a.getNombre())){
            throw new AlumnoRepetidoException(a.getNombre());
        }
        alumnos.add(a);
    }

    private boolean existeAlumnoDeNombre(String nombre) {
        long count = this.alumnos.stream().filter(alumno -> alumno.getNombre().equals(nombre)).count();
        return count>0;
    }

    @Override
    public Page<Alumno> page(Pageable page) {
        int desde = page.getPageNumber() * page.getPageSize();
        List<Alumno> subList = this.alumnos.subList(desde, desde + page.getPageSize());
        return new PageImpl<Alumno>(subList, page, page.getPageSize());
    }

    @Override
    public Alumno porNombre(String nombre) {
        return this.alumnos.stream().filter(alumno -> alumno.getNombre().equals(nombre)).findFirst().get();
    }

    @Override
    public List<Alumno> all() {
        return this.alumnos;
    }
}
