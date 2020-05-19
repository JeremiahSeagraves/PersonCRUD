package com.jeremiahseagraves.richlogin.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author jeremiah.seagraves
 * @created 5/19/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {
    private String token;
}
