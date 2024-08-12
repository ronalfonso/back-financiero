package com.devsu.servicio.cuentas.infrastructure;

import com.devsu.servicio.cuentas.application.CuentaService;
import com.devsu.servicio.cuentas.application.RetiroStrategy;
import com.devsu.servicio.cuentas.domain.dto.MovimientoRequestDto;
import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import com.devsu.servicio.cuentas.domain.entity.Movimiento;
import com.devsu.servicio.cuentas.domain.enums.TipoMovimiento;
import com.devsu.servicio.cuentas.domain.repository.MovimientosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
@Service
@RequiredArgsConstructor
public class RetiroStrategyImpl implements RetiroStrategy {

    private final MovimientosRepository movimientosRepository;

    private final CuentaService cuentaService;

    @Override
    public void ejecutarRetiro(MovimientoRequestDto movimientoRequestDto) {
        System.out.println("Realizando retiro..."+ movimientoRequestDto.getCuentaId()+" "+movimientoRequestDto.getMonto().multiply(BigDecimal.valueOf(-1)));
        Cuenta cuenta = cuentaService.cuentaExist(movimientoRequestDto.getCuentaId());
        List<Movimiento> movimientoAnterior = movimientosRepository.findUltimoMovimientoPorCuentaId(cuenta.getId());
        BigDecimal saldoActualizado = null;
        if(movimientoAnterior.isEmpty()){
            saldoActualizado = cuenta.getSaldoInicial().subtract(movimientoRequestDto.getMonto());
        } else {
            saldoActualizado = movimientoAnterior.get(0).getSaldo().subtract(movimientoRequestDto.getMonto());
        }

        Movimiento movimiento = Movimiento.builder()
                .fecha(LocalDateTime.now())
                .tipoMovimiento(TipoMovimiento.RETIRO.getMessage()+" -"+movimientoRequestDto.getMonto())
                .valor(movimientoRequestDto.getMonto().multiply(BigDecimal.valueOf(-1)))
                .saldo(saldoActualizado)
                .cuenta(cuenta)
                .build();

        movimientosRepository.save(movimiento);

    }
}
