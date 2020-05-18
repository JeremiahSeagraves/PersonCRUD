package com.jeremiahseagraves.richlogin.config;

import com.jeremiahseagraves.richlogin.domain.Direccion;
import com.jeremiahseagraves.richlogin.domain.Persona;
import com.jeremiahseagraves.richlogin.repository.DireccionRepository;
import com.jeremiahseagraves.richlogin.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Configuration
@Slf4j
public class LoadDB {

    @Bean
    CommandLineRunner initDatabase(PersonaRepository personaRepository, DireccionRepository direccionRepository) {
        return args -> {
            Persona persona1 = new Persona("Juanito", "Pérez", 25, "O+");
            personaRepository.save(persona1);

            Set<Direccion> direcciones1 = new HashSet<>(Arrays.asList(new Direccion("A", "32", persona1),
                    new Direccion("B", "33", persona1)));
            direccionRepository.saveAll(direcciones1);
            log.info("Cargando " + persona1);


            Persona persona2 = new Persona("María", "Ortega", 32, "O-");
            personaRepository.save(persona2);
            Set<Direccion> direcciones2 = new HashSet<>(Arrays.asList(new Direccion("C", "34", persona2),
                    new Direccion("D", "35", persona2)));
            direccionRepository.saveAll(direcciones2);

            log.info("Cargando " + persona2);


            Persona p1 = personaRepository.findById(persona1.getId()).get();
            log.info(p1.toString());
        };
    }
}
