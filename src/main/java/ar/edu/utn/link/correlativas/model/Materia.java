package ar.edu.utn.link.correlativas.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Entity
public class Materia {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@NotBlank	
	private String nombre;
	@Min(1)
	private int anio;
	
	
	private boolean activo;
	
	@ManyToMany
	private Collection<Materia> correlativas;


	public Materia() {}
	
	public Materia(String nombre, int anio) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.activo = true;
	}
	
	
	
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Materia> getCorrelativas() {
		return new ArrayList<Materia>(this.correlativas);
	}
		
	protected void setCorrelativas(Collection<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	public void agregarCorrelativa(Materia corr) throws CorrelativasException {
		if(this.equals(corr)) {
			throw new CorrelativasException("una materia no puede ser corr de ella misma",this,corr);
		}
		if(this.getCorrelativas().contains(corr)) {
			throw new CorrelativasException("ya es correlativa",this,corr);
		}
		if(!corr.isActivo() || !this.isActivo() ) {
			throw new CorrelativasException("la materia no es valida",this,corr);
		}
		this.correlativas.add(corr);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", correlativas=" + correlativas + "]";
	}
	
	

}
