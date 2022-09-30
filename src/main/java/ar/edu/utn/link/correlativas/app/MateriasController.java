package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/materias_old")
public class MateriasController {

    @Autowired
    RepoMateriaJPA repo;

/*
    @GetMapping("/{nombre}")
    public Materia materia(@PathVariable("nombre") String nombre){
        return repo.porNombre(nombre);
    }
*/

/*
    @PostMapping(params = {"/"})
    public String alta(@RequestBody @Valid Materia materia, BindingResult bindingResult) throws MateriaRepetidaException{
        if(bindingResult.hasErrors()){
            return "Error en cargar la materia.";
        }
        else{
            repo.save(materia);
            return "Materia cargada.";
        }
    }
*/

}
