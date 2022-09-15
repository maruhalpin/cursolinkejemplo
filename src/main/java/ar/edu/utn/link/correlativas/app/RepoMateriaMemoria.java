package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import ar.edu.utn.link.correlativas.app.RepoMateria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoMateriaMemoria implements RepoMateria{

    private List<Materia> materias;

    public RepoMateriaMemoria() {
        super();
        this.materias = new ArrayList<>();
    }
    @Override
    public void save(Materia m){
        materias.add(m);
        System.out.println("Materia: " + m.getNombre());
    }

    public List<Materia> all(){
        return this.materias;
    }

    @Override
    public Materia porNombre(String nombre){
        return this.materias.stream().filter( materia -> materia.getNombre().equals(nombre)).findFirst().get();
    }
}
