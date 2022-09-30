package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/alumnos_old")
public class AlumnosController {

    @Autowired
    RepoAlumnoJPA repo;

/*
    @GetMapping("/{nombre}")
    public Alumno alumno(@PathVariable("nombre") String nombre){
        return repo.porNombre(nombre);
    }

    @PostMapping(params = {"/"})
    public String alta(@RequestBody @Valid Alumno alumno, BindingResult bindingResult) throws AlumnoRepetidoException{
        if(bindingResult.hasErrors()){
            return "Error en cargar el alumno.";
        }
        else{
            repo.save(alumno);
            return "Alumno cargado.";
        }
    }
*/

}
