package com.devsu.servicio.cuentas.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
@Data
public class MovimientoRequestDto {
    private Long cuentaId;
    private BigDecimal monto;
}
