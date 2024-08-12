package com.devsu.servicio.clientes.domain.entity;

import com.devsu.servicio.clientes.domain.enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas", schema = "clients")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
    private static final long serialVersionUID = 9005891884714710963L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    @NotBlank(message = "EL nombre es requerido")
    private String nombre;

    @Column(name = "genero", nullable = false)
    @NotNull(message = "EL genero es requerido")
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "edad", nullable = false)
    @NotNull(message = "La edad es requerida")
    private Long edad;

    @Column(name = "identificacion", nullable = false)
    @NotNull(message = "La identificacion es requerida")
    private Integer identificacion;

    @Column(name = "direccion", nullable = false)
    @NotBlank(message = "La direccion es requerida")
    @Size(min = 10, max = 150, message = "La dirección debe tener entre 10 y 150 caracteres.")
    private String direccion;

    @Column(name = "telefono", nullable = false)
    @NotBlank(message = "EL telefono es requerido")
    private String telefono;

}
