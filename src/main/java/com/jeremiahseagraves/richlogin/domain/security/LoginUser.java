package com.jeremiahseagraves.richlogin.domain.security;

import lombok.Data;

/**
 * @author jeremiah.seagraves
 * @created 5/19/2020
 */
@Data
public class LoginUser {
    private String username;
    private String password;
}
