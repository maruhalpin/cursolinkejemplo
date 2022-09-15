package ar.edu.utn.link.correlativas.app;

import org.springframework.stereotype.Repository;

import ar.edu.utn.link.correlativas.Materia;

import java.util.List;

@Repository
public interface RepoMateria {

    public void save(Materia m);

    Materia porNombre(String nombre);

    List<Materia> all();
}
