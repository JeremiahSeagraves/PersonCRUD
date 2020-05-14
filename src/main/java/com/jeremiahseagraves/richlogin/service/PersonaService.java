package com.jeremiahseagraves.richlogin.service;

import com.jeremiahseagraves.richlogin.domain.Persona;
import com.jeremiahseagraves.richlogin.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Service
@Slf4j
public class PersonaService {

    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Async
    public CompletableFuture<List<Persona>> getAll() {
        log.info("Getting all personas");
        return CompletableFuture.completedFuture(personaRepository.findAll());
    }

    @Async
    public CompletableFuture<Persona> saveOrUpdate(Persona persona) {
        log.info("Saving or updating persona: {}", persona);
        return CompletableFuture.completedFuture(personaRepository.save(persona));
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}
