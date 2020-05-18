package com.jeremiahseagraves.richlogin.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author jeremiah.seagraves
 * @created 5/14/2020
 */
@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NonNull
    @NotEmpty
    private String nombre;

    @NotNull
    @NonNull
    @NotEmpty
    private String apellido;

    @Min(0)
    @NonNull
    private int edad;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @JsonManagedReference
    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Direccion> direcciones;

}
