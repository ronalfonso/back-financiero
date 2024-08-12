package com.devsu.servicio.cuentas.application;

import com.devsu.servicio.cuentas.domain.dto.MovimientoRequestDto;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
public interface RetiroStrategy {

    void ejecutarRetiro(MovimientoRequestDto movimientoRequestDto);
}
