package ar.edu.utn.link.correlativas.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.dtos.DTOAlumno;

@RepositoryRestResource(path="alumnos",excerptProjection = DTOAlumno.class)
public interface RepoAlumnoJPA  extends JpaRepository<Alumno, Long>  {

	Alumno findAlumnoByNombreAndApellido(String nombre,String apellido);
	
	Page<Alumno> findAlumnoByNombre(String nombre,Pageable page);	
	
	
	
	
}
