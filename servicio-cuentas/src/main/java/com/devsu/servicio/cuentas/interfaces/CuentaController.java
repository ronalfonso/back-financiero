package com.devsu.servicio.cuentas.interfaces;

import com.devsu.servicio.cuentas.application.CuentaService;
import com.devsu.servicio.cuentas.domain.dto.CuentaActualizarRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaResponseDto;
import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import com.devsu.servicio.cuentas.helpers.Message;
import com.devsu.servicio.cuentas.specifications.CuentasSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@RestController
@RequestMapping("/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping("/listar")
    public ResponseEntity<Page<CuentaResponseDto>> obtenerTodos(CuentasSpecification spec, Pageable pageable) {
        return ResponseEntity.ok(cuentaService.obtenerTodos(spec, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaResponseDto> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.detalle(id));
    }

    @PostMapping
    public ResponseEntity<CuentaResponseDto> crear(@RequestBody CuentaRequestDto cuentaRequestDto) {
        return new ResponseEntity<CuentaResponseDto>(cuentaService.crear(cuentaRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaResponseDto> actualizar(@PathVariable Long id, @RequestBody CuentaActualizarRequestDto cuentaRequestDto) {
        // Implementar actualización de cuenta
        return ResponseEntity.ok(cuentaService.actualizar(id, cuentaRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> eliminar(@PathVariable Long id) {
        return new ResponseEntity<Message>(cuentaService.delete(id), HttpStatus.OK);
    }
}
