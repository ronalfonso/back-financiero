package com.devsu.servicio.cuentas.domain.repository;

import com.devsu.servicio.cuentas.domain.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
}
