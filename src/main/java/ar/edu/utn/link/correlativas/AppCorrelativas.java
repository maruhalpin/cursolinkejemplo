package ar.edu.utn.link.correlativas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ar.edu.utn.link.correlativas.app.RepoAlumnoJPA;
import ar.edu.utn.link.correlativas.app.RepoMateriaJPA;
import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;

@SpringBootApplication
public class AppCorrelativas {
	
	@Autowired
	RepositoryRestConfiguration config;

	
	
	@Value("${algo}")
	private int unNumero;
	
	@Value("${path}")
	private String pepito;
	
	public static void main(String[] args) {		
		SpringApplication.run(AppCorrelativas.class, args);		
	}
	
	
	@Bean
	public CommandLineRunner init(RepoMateriaJPA repo,RepoAlumnoJPA repoAlumno) {
		
		config.exposeIdsFor(Materia.class);
		
		return (cosas) -> {
			
			repo.save(new Materia("SO",2));
			repo.save(new Materia("DDS",3));
			Materia algo = new Materia("Algo",1);
			repo.save(algo);
			repo.save(new Materia("Analisis",2));
			repo.save(new Materia("Sintaxis",2));
			Alumno pepe = new Alumno("Pepe","Gomez");
			pepe.getMateriasAprobadas().add(algo);
			repoAlumno.save(pepe);
			repoAlumno.save(new Alumno("Juan","Benitez"));
			repoAlumno.save(new Alumno("Jorge","Sosa"));
			
		};
	}

	
	
}
