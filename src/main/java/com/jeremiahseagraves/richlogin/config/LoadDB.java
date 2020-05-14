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
            Persona persona1 = Persona.builder().nombre("Juanito").apellido("Pérez").edad(25).tipoSangre("O+").build();
            personaRepository.save(persona1);

            Set<Direccion> direcciones1 = new HashSet<>(Arrays.asList(Direccion.builder().calle("A").numero("32").persona(persona1).build(),
                    Direccion.builder().calle("B").numero("33").persona(persona1).build()));
            direccionRepository.saveAll(direcciones1);
            log.info("Cargando " + persona1);


            Persona persona2 = Persona.builder().nombre("María").apellido("Ortega").edad(32).tipoSangre("O-").build();
            personaRepository.save(persona2);
            Set<Direccion> direcciones2 = new HashSet<>(Arrays.asList(Direccion.builder().calle("C").numero("34").persona(persona2).build(),
                    Direccion.builder().calle("D").numero("35").persona(persona2).build()));
            direccionRepository.saveAll(direcciones2);

            log.info("Cargando " + persona2);


            Persona p1 = personaRepository.findById(persona1.getId()).get();
            log.info(p1.toString());
        };
    }
}
