package com.jeremiahseagraves.richlogin.repository;

import com.jeremiahseagraves.richlogin.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jeremiah.seagraves
 * @created 5/19/2020
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
