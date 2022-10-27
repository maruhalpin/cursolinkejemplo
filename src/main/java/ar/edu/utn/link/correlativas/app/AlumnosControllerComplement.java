package ar.edu.utn.link.correlativas.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;

@RepositoryRestController
public class AlumnosControllerComplement {

	@Autowired
	RepoAlumnoJPA repoAlumno;
	@Autowired
	RepoMateriaJPA repoMateria;
	
	@Transactional
	@PostMapping("/alumnos/{alumnoId}/aprobadas")
	public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
			@PathVariable("alumnoId") Long alumnoId,
			@RequestBody Long corrId
			) throws Exception {
		
		// Validar input y obtener objetos (Capa Datos) ------------------------------
		Optional<Alumno> alumnoOptinal = repoAlumno.findById(alumnoId);
		Optional<Materia> materiaOptional = repoMateria.findById(corrId);
		
		if(alumnoOptinal.isEmpty() || materiaOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumno = alumnoOptinal.get();
		Materia materia = materiaOptional.get();
		
		//--------------  Dominio   -----------------------
		
		alumno.agregarMateriaAprobada(materia)	;
		
		//-------------- Rta al usuario  -----------------------
		
		return ResponseEntity.ok(alumno);
	} 
	
	
}
