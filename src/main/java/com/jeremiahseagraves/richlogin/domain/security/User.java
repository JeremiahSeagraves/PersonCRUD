package com.jeremiahseagraves.richlogin.domain.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author jeremiah.seagraves
 * @created 5/19/2020
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String username;

    @Column
    @JsonIgnore
    @NonNull
    private String password;

    @Column
    @NonNull
    private long salary;

    @Column
    @NonNull
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;

    public User(long id) {
        this.id = id;
    }
}