package com.devsu.servicio.cuentas.application;


import com.devsu.servicio.cuentas.domain.dto.CuentaActualizarRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaResponseDto;
import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import com.devsu.servicio.cuentas.helpers.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;


/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
public interface CuentaService {

    Page<CuentaResponseDto> obtenerTodos(Specification<Cuenta> spec, Pageable pageable);

    CuentaResponseDto detalle(Long id);

    CuentaResponseDto crear(CuentaRequestDto cuentaRequestDto);

    CuentaResponseDto actualizar(Long id, CuentaActualizarRequestDto cuentaRequestDto);

    Message delete(Long id);

    Cuenta cuentaExist(Long id);
}
