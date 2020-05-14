package com.jeremiahseagraves.richlogin.controller;

import com.jeremiahseagraves.richlogin.domain.Persona;
import com.jeremiahseagraves.richlogin.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@RestController
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/persona")
    public CompletableFuture<ResponseEntity> getAll() {
        return personaService.getAll().<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleGetFailure);
    }

    private static Function<Throwable, ResponseEntity<? extends List<Persona>>> handleGetFailure = throwable -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    private static Function<Throwable, ResponseEntity<? extends Persona>> handleSaveOrUpdateFailure = throwable -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    @PostMapping("/persona")
    public CompletableFuture<ResponseEntity> save(@RequestBody @Validated Persona persona) {
        return personaService.saveOrUpdate(persona).<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleSaveOrUpdateFailure);
    }

    @PutMapping("/persona")
    public CompletableFuture<ResponseEntity> update(@RequestBody Persona persona) {
        return personaService.saveOrUpdate(persona).<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleSaveOrUpdateFailure);
    }


    @DeleteMapping("/persona/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
