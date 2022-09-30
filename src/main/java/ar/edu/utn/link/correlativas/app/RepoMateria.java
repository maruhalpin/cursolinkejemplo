package ar.edu.utn.link.correlativas.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ar.edu.utn.link.correlativas.model.Materia;
import java.util.List;

@Repository
public interface RepoMateria {

    public void save(Materia m) throws MateriaRepetidaException;

    Page<Materia> page(Pageable pageable);

    public List<Materia> all();

    public Materia porNombre(String nombre);

    public List<Materia> porAnio(Integer anio);

}
