package com.jeremiahseagraves.richlogin.domain.dto;

import lombok.Data;

/**
 * @author jeremiah.seagraves
 * @created 5/19/2020
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private int age;
    private int salary;
}
