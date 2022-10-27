package ar.edu.utn.link.correlativas.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.correlativas.model.Materia;

@Repository
public class RepoMateriaMemoria implements RepoMateria {

	private List<Materia> materias;

	public RepoMateriaMemoria() {
		super();
		this.materias = new ArrayList<>();
	}

	@Override
	public void save(Materia m) throws MateriaRepetidaException {	
		if(this.existeMateriaDeNombre(m.getNombre())) {
			throw new MateriaRepetidaException(m.getNombre());
		}
		materias.add(m);				
	}
	@Override
	public List<Materia> all() {
		
		return this.materias;
	}
	@Override
	public boolean existeMateriaDeNombre(String nombre) {
		
		long count = this.materias.stream().filter( materia -> materia.getNombre().equals(nombre)).count();
		return count > 0;
	}

	
	@Override
	public Materia porNombre(String nombre) {
		
		return this.materias.stream().filter( materia -> materia.getNombre().equals(nombre)).findFirst().get();
	}

	@Override
	public List<Materia> porAnio(int anio) {
		
		return this.materias.stream().filter( materia -> materia.getAnio().equals(anio)
				).collect(Collectors.toList());
	}
	
	@Override
	public Page<Materia> page(Pageable pageble) {
		int desde = pageble.getPageNumber() * pageble.getPageSize();
		List<Materia> subList2 = this.materias.subList(desde, desde + pageble.getPageSize());
		return new PageImpl<Materia>(subList2, pageble, this.materias.size());
		
	}
	
	
	
	
	
}
