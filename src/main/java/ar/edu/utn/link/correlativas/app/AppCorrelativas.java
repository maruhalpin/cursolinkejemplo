package ar.edu.utn.link.correlativas.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.edu.utn.link.correlativas.app.RepoMateria;
import ar.edu.utn.link.correlativas.Materia;
@SpringBootApplication
public class AppCorrelativas {

    @Value("${path}")
    private String pepito;

//    @Autowired
//    private RepoMateria repo;

    public static void main(String[] args)
    {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner ejemplo(RepoMateria repo){
        return (cosas) -> {
            repo.save(new Materia("SO"));
            System.out.println(0);
        };

    }
}

