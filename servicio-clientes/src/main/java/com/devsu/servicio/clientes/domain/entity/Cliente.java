package com.devsu.servicio.clientes.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @Project clientes_ms
 * @Author raalf on 30/7/2024
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes", schema = "clients")
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Persona {

    @Column(name = "cliente_id", nullable = false, unique = true)
    private Integer clienteId;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
