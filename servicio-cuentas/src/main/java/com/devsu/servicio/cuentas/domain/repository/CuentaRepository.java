package com.devsu.servicio.cuentas.domain.repository;

import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>, JpaSpecificationExecutor<Cuenta> {

//    Page<Cuenta> findAll(Specification<Cuenta> spec, Pageable pageable);
}
