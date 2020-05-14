package com.jeremiahseagraves.richlogin.repository;

import com.jeremiahseagraves.richlogin.domain.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
