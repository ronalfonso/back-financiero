package com.devsu.servicio.cuentas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuentas", schema = "accounts")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private Integer numeroCuenta;

    @NotNull
    @Column(name = "saldo_inicial", nullable = false)
    private BigDecimal saldoInicial;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "tipo_cuenta_id")
    private TipoCuenta tipoCuenta;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;
}

