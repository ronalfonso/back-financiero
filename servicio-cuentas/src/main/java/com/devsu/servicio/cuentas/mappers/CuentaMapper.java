package com.devsu.servicio.cuentas.mappers;


import com.devsu.servicio.cuentas.domain.dto.CuentaResponseDto;
import com.devsu.servicio.cuentas.domain.entity.Cliente;
import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import com.devsu.servicio.cuentas.domain.entity.TipoCuenta;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
public class CuentaMapper {

    public static CuentaResponseDto toCuentaResponseDto(Cuenta cuenta, Cliente cliente, TipoCuenta tipoCuenta){
        return CuentaResponseDto.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(tipoCuenta.getNombre())
                .saldoInicial(cuenta.getSaldoInicial())
                .cliente(cliente.getNombre())
                .build();
    }
}
