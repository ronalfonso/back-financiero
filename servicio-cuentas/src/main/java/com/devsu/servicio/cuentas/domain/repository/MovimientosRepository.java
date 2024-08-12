package com.devsu.servicio.cuentas.domain.repository;

import com.devsu.servicio.cuentas.domain.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
public interface MovimientosRepository extends JpaRepository<Movimiento, Long> {

    @Query("SELECT m FROM Movimiento m WHERE m.cuenta.id = :cuentaId ORDER BY m.fecha DESC")
    List<Movimiento> findUltimoMovimientoPorCuentaId(@Param("cuentaId") Long cuentaId);
}
