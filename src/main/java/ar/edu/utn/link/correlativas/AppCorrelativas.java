package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.*;
import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppCorrelativas {

    @Value("${algo}")
    private int unNumero;

    @Value("${path}")
    private String path;

    public static void main(String[] args)
    {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner materia(RepoMateriaJPA repoMateria, RepoAlumnoJPA repoAlumno){
        return (cosas) -> {
            repoMateria.save(new Materia("Sistemas Operativos", 3));
            repoMateria.save(new Materia("Análisis matemático 1", 1));
            repoMateria.save(new Materia("Sintáxis", 2));
            repoMateria.save(new Materia("Paradigmas", 2));
            repoAlumno.save(new Alumno("Juan", "Gomez"));
            repoAlumno.save(new Alumno("Luis", "Lopez"));
            repoAlumno.save(new Alumno("Carlos", "Gardel"));
            repoAlumno.save(new Alumno("Laura", "Pereyra"));
        };
    }
}

