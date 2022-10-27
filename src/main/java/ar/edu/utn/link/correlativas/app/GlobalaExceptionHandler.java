package ar.edu.utn.link.correlativas.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.edu.utn.link.correlativas.model.CorrelativasException;

@ControllerAdvice
public class GlobalaExceptionHandler {

	@ExceptionHandler(MateriaRepetidaException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	String materiaRepetida(MateriaRepetidaException ex) {
		
		return "la materia " + ex.getNombreMateria() + " ya existe";
	}
	
	@ExceptionHandler(CorrelativasException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String correlativaMal(CorrelativasException ex) {
		
		return ex.getLocalizedMessage();
	}

}
