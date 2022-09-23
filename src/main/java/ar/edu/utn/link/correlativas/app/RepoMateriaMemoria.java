package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepoMateriaMemoria implements RepoMateria{

    private List<Materia> materias;

    public RepoMateriaMemoria() {
        super();
        this.materias = new ArrayList<>();
    }

    @Override
    public void save(Materia m) throws MateriaRepetidaException{
        if(this.existeMateriaDeNombre(m.getNombre()))
        {
            throw new MateriaRepetidaException(m.getNombre());
        }
        materias.add(m);
    }

    public boolean existeMateriaDeNombre(String nombre)
    {
        long count = this.materias.stream().filter(materia -> materia.getNombre().equals(nombre)).count();
        return count>0;
    }

    @Override
    public Page<Materia> page(Pageable page) {
        int desde = page.getPageNumber() * page.getPageSize();
        List<Materia> subList = this.materias.subList(desde, desde + page.getPageSize());
        return new PageImpl<Materia>(subList, page, page.getPageSize());
    }

    public List<Materia> all()
    {
        return this.materias;
    }

    @Override
    public Materia porNombre(String nombre){
        return this.materias.stream().filter( materia -> materia.getNombre().equals(nombre)).findFirst().get();
    }

    @Override
    public List<Materia> porAnio(Integer anio){
        return this.materias.stream().filter( materia -> materia.getAnio().equals(anio)).collect(Collectors.toList());
    }
}
