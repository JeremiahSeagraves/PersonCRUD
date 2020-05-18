package com.jeremiahseagraves.richlogin.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Entity
@Table(name = "direccion", uniqueConstraints = {@UniqueConstraint(columnNames = {"calle", "persona_id", "numero"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    @NotEmpty
    private String calle;

    @NotNull
    @NonNull
    @NotEmpty
    private String numero;

    @JsonBackReference
    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id", nullable = false)
    @ToString.Exclude
    private Persona persona;

}
