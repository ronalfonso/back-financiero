package com.devsu.servicio.cuentas.domain.enums;

import com.devsu.servicio.cuentas.application.DepositoStrategy;
import com.devsu.servicio.cuentas.application.RetiroStrategy;
import com.devsu.servicio.cuentas.application.ServiceSupplier;
import com.devsu.servicio.cuentas.domain.dto.MovimientoRequestDto;
import com.devsu.servicio.cuentas.infrastructure.ServiceLocator;
import lombok.Getter;

import java.util.function.Consumer;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
@Getter
public enum TipoMovimiento {

    DEPOSITO("DEPOSITO", "deposito","Deposito de", (movimiento) -> {
        ServiceSupplier<DepositoStrategy> supplier =
                ServiceLocator.getServiceSupplier(DepositoStrategy.class);
        DepositoStrategy service = supplier.get();
        service.ejecutarDeposito((MovimientoRequestDto) movimiento);
    }),
    RETIRO("RETIRO", "retiro","Retiro de", (movimiento) -> {
        ServiceSupplier<RetiroStrategy> supplier =
                ServiceLocator.getServiceSupplier(RetiroStrategy.class);
        RetiroStrategy service = supplier.get();
        service.ejecutarRetiro((MovimientoRequestDto) movimiento);
    });

    private final String value;
    private final String path;
    private final String message;
    private final Consumer strategy;

    TipoMovimiento(String value, String path,String message, Consumer strategy) {
        this.value = value;
        this.path = path;
        this.message = message;
        this.strategy = strategy;
    }

    public void ejecutarMovimiento(MovimientoRequestDto movimiento) {
        strategy.accept(movimiento);;
    }
}
