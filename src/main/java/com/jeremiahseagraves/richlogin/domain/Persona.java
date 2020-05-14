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
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedEntityGraph(name = "Persona.ConDirecciones", attributeNodes = @NamedAttributeNode("direcciones"))
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nombre;

    @NotNull
    @NotEmpty
    private String apellido;

    @Min(0)
    private int edad;

    @NotNull
    @NotEmpty
    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @JsonManagedReference
    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Direccion> direcciones;

}
