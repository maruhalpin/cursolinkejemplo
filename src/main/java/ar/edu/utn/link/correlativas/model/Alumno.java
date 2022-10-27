package ar.edu.utn.link.correlativas.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alumno {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	
	private String apellido;
	
	@Transient
	@JsonIgnore
	private List<Curso> cursos;
	
	@ManyToMany
	private Collection<Materia>  materiasAprobadas;
	
		
	public Alumno() {
		this.materiasAprobadas = new ArrayList<Materia>();
		     
	}
	
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Alumno(String nombre,String apellido) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public Collection<Materia> getMateriasAprobadas() {
		return  new ArrayList<Materia>(this.materiasAprobadas);
	}
	protected void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public void inscribir(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	public void agregarMateriaAprobada(Materia materia) {
		// chqeueos-..
		
		//
		this.materiasAprobadas.add(materia);
		
	}
	
	
	

}
