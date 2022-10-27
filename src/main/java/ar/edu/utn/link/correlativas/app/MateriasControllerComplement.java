package ar.edu.utn.link.correlativas.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.utn.link.correlativas.model.CorrelativasException;
import ar.edu.utn.link.correlativas.model.Materia;

@RepositoryRestController
public class MateriasControllerComplement {

	@Autowired
	RepoMateriaJPA repo;
	
	@Transactional
	@DeleteMapping("/materias/{materiaId}")
	public @ResponseBody ResponseEntity<Object> delete(@PathVariable("materiaId") Long materiaId) {
		Optional<Materia> materiaOptional = repo.findById(materiaId);
		
		
		if(materiaOptional.isPresent()) {
			Materia materia = materiaOptional.get();
			if(materia.isActivo()) {
				materia.setActivo(false);			
				return ResponseEntity.ok().body("materia borrada ok");	
			}				
		} 
		return  new ResponseEntity<Object>("la materia no existe",HttpStatus.NOT_FOUND) ; //"la materia no existe";
	}
	
	@Transactional
	@PostMapping("/materias/{materiaId}/correlativas")
	public @ResponseBody ResponseEntity<Object> agregarCorrelativa(
			@PathVariable("materiaId") Long materiaId,
			@RequestBody Long corrId
			) throws Exception {
		
		// Validar input y obtener objetos (Capa Datos) ------------------------------
		Optional<Materia> materiaOptional = repo.findById(materiaId);
		Optional<Materia> materiaCorrOptional = repo.findById(corrId);
		
		if(materiaOptional.isEmpty() || materiaCorrOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Materia materia = materiaOptional.get();
		Materia correlativa = materiaCorrOptional.get();
		
		//--------------  Dominio   -----------------------
		
		materia.agregarCorrelativa(correlativa);	
		
		//-------------- Rta al usuario  -----------------------
		
		return ResponseEntity.ok(materia);
	} 
	
	
}
