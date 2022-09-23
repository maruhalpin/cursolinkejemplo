package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ar.edu.utn.link.correlativas.Materia;

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
    public CommandLineRunner materia(RepoMateria repo, RepoAlumno repoAlumno){
        return (cosas) -> {
            try {
                repo.save(new Materia("Sistemas Operativos", 3));
                repo.save(new Materia("Análisis matemático 1", 1));
                repo.save(new Materia("Sintáxis", 2));
                repo.save(new Materia("Paradigmas", 2));
                repoAlumno.save(new Alumno("Juan"));
                repoAlumno.save(new Alumno("Luis"));
                repoAlumno.save(new Alumno("Carlos"));
                repoAlumno.save(new Alumno("Laura"));
            }
            catch (MateriaRepetidaException e) {
                throw new RuntimeException(e);
            } catch (AlumnoRepetidoException e) {
                throw new RuntimeException(e);
            }
        };
    }
}

