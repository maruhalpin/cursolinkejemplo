package ar.edu.utn.link.correlativas.model.dtos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import ar.edu.utn.link.correlativas.model.Alumno;

@Projection(name="alumno2",types = {Alumno.class})
public interface DTOAlumno2 {

	@Value("#{target.apellido}, #{target.nombre}")
	String getNombreCompleto();
	
}
