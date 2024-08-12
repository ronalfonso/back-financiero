package com.devsu.servicio.cuentas.interfaces;

import com.devsu.servicio.cuentas.domain.dto.CuentaRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaResponseDto;
import com.devsu.servicio.cuentas.domain.dto.MovimientoRequestDto;
import com.devsu.servicio.cuentas.domain.enums.TipoMovimiento;
import com.devsu.servicio.cuentas.helpers.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Project servicio-cuentas
 * @Author raalf on 7/8/2024
 */
@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovimientoController {


    @GetMapping("/listar")
    public Message obtenerTodos() {
        return new Message("Resultado");
    }

    @PostMapping("/{tipo}")
    public ResponseEntity<String> procesarMovimiento(@PathVariable String tipo, @RequestBody MovimientoRequestDto movimientoRequest) {
        TipoMovimiento tipoMovimiento = TipoMovimiento.valueOf(tipo.toUpperCase());
        tipoMovimiento.ejecutarMovimiento(movimientoRequest);

        return ResponseEntity.ok("Movimiento procesado");
    }
}
