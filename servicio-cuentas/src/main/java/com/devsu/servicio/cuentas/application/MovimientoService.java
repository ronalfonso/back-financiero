package com.devsu.servicio.cuentas.application;

import com.devsu.servicio.cuentas.domain.entity.Movimiento;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
public interface MovimientoService {

    Movimiento getMovimientoAnterior(Long id);
}
