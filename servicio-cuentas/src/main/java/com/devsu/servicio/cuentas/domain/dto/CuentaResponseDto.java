package com.devsu.servicio.cuentas.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaResponseDto {

    private Integer numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private String cliente;

}
