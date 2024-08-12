package com.devsu.servicio.cuentas.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@Data
public class CuentaRequestDto {

    private Integer numeroCuenta;
    private Long tipoCuentaId;
    private BigDecimal saldoInicial;
    private Long clienteId;

}
