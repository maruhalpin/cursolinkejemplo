package ar.edu.utn.link.correlativas.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.correlativas.model.Materia;

@RepositoryRestResource(path = "materias")
public interface RepoMateriaJPA extends JpaRepository<Materia, Long> {

	@Override
	@RestResource(exported = false)
	void deleteById(Long id);
		@Override
	@RestResource(exported = false)
	void delete(Materia id);
		
		
	@RestResource(exported = false)
	Page<Materia> findByAnio(Integer anio,Pageable page);
	

	Materia findByNombre(String nombre);
}
