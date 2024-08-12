package com.devsu.servicio.cuentas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
    * @Project servicio-cuentas
    * @Author raalf on 1/8/2024
*/
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    private Integer id;

    private Integer clienteId;

    private String contrasena;

    private Boolean estado;

    private String nombre;

    private String genero;

    private Long edad;

    private Integer identificacion;

    private String direccion;

    private String telefono;
}

