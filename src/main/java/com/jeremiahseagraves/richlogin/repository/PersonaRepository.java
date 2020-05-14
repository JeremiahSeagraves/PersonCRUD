package com.jeremiahseagraves.richlogin.repository;

import com.jeremiahseagraves.richlogin.domain.Persona;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @EntityGraph(value = "Persona.ConDirecciones")
    List<Persona> findAll();

}
