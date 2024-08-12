package com.devsu.servicio.cuentas.infrastructure;

import com.devsu.servicio.cuentas.application.CuentaService;
import com.devsu.servicio.cuentas.clients.ClientesClientRest;
import com.devsu.servicio.cuentas.domain.dto.CuentaActualizarRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaRequestDto;
import com.devsu.servicio.cuentas.domain.dto.CuentaResponseDto;

import com.devsu.servicio.cuentas.domain.entity.Cliente;
import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import com.devsu.servicio.cuentas.domain.entity.TipoCuenta;
import com.devsu.servicio.cuentas.domain.repository.CuentaRepository;
import com.devsu.servicio.cuentas.domain.repository.TipoCuentaRepository;
import com.devsu.servicio.cuentas.exception.ResourceBadRequestException;
import com.devsu.servicio.cuentas.exception.ResourceNotFoundException;
import com.devsu.servicio.cuentas.helpers.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.devsu.servicio.cuentas.mappers.CuentaMapper.toCuentaResponseDto;


/**
 * @Project servicio-cuentas
 * @Author raalf on 31/7/2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    private final TipoCuentaRepository tipoCuentaRepository;

    private final ClientesClientRest clientesClientRest;

    @Override
    public Page<CuentaResponseDto> obtenerTodos(Specification<Cuenta> spec, Pageable pageable) {
        List<TipoCuenta> tipoCuentaList = tipoCuentaRepository.findAll();
        Page<Cuenta> cuentasPageable = cuentaRepository.findAll(spec, pageable);
        List<Cuenta> cuentaList = cuentasPageable.getContent();
        List<CuentaResponseDto> cuentaResponseDtoList = cuentaList.stream()
                .map(cuenta ->
                        CuentaResponseDto.builder()
                                .numeroCuenta(cuenta.getNumeroCuenta())
                                .saldoInicial(cuenta.getSaldoInicial())
                                .tipoCuenta(getTipoCuenta(tipoCuentaList, cuenta.getTipoCuenta().getId()))
                                .cliente(getCliente(Long.valueOf(cuenta.getClienteId())).getNombre())
                                .build()
                ).collect(Collectors.toList());

        return new PageImpl<>(cuentaResponseDtoList, pageable, cuentasPageable.getTotalElements());
    }

    @Override
    public CuentaResponseDto detalle(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new ResourceBadRequestException("No existe una cuenta con id: " + id)
        );
        Cliente cliente = getCliente(Long.valueOf(cuenta.getClienteId()));
        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuenta.getTipoCuenta().getId())
                .orElseThrow(() -> new ResourceBadRequestException("No existe un tipo de cuenta con id: " + cuenta.getTipoCuenta().getId()));
        return toCuentaResponseDto(cuenta, cliente, tipoCuenta);
    }

    @Override
    public CuentaResponseDto crear(CuentaRequestDto cuentaRequestDto) {

        Cliente cliente = getCliente(cuentaRequestDto.getClienteId());

        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuentaRequestDto.getTipoCuentaId())
                .orElseThrow(() -> new ResourceBadRequestException("No existe un tipo de cuenta con id: " + cuentaRequestDto.getTipoCuentaId()));

        Cuenta cuenta = Cuenta.builder()
                .numeroCuenta(cuentaRequestDto.getNumeroCuenta())
                .tipoCuenta(tipoCuenta)
                .saldoInicial(cuentaRequestDto.getSaldoInicial())
                .estado(true)
                .clienteId(cliente.getId())
                .build();

        return toCuentaResponseDto(cuentaRepository.save(cuenta), cliente, tipoCuenta);
    }

    @Override
    public CuentaResponseDto actualizar(Long id, CuentaActualizarRequestDto cuentaRequestDto) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new ResourceBadRequestException("No existe una cuenta con id: " + id)
        );
        Cliente cliente = getCliente(Long.valueOf(cuenta.getClienteId()));
        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(cuentaRequestDto.getTipoCuentaId() != null ? cuentaRequestDto.getTipoCuentaId() : cuenta.getTipoCuenta().getId())
                .orElseThrow(() -> new ResourceBadRequestException("No existe un tipo de cuenta con id: " + cuenta.getTipoCuenta().getId()));

        if (Objects.nonNull(cuentaRequestDto.getTipoCuentaId())) {
            cuenta.setTipoCuenta(tipoCuenta);
        }

        if (Objects.nonNull(cuentaRequestDto.getSaldoInicial())) {
            cuenta.setSaldoInicial(cuentaRequestDto.getSaldoInicial());
        }

        return toCuentaResponseDto(cuenta, cliente, tipoCuenta);
    }

    @Override
    public Message delete(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(
                () -> new ResourceBadRequestException("No existe una cuenta con id: " + id)
        );
        cuentaRepository.deleteById(id);
        return new Message("Cuenta eliminada con éxito");
    }

    @Override
    public Cuenta cuentaExist(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe una cuenta con id: \" + id"));
    }

    private String getTipoCuenta(List<TipoCuenta> tipoCuentaList, Long tipoCuentaId) {
        String tipo = null;
        for (TipoCuenta tipoCuenta : tipoCuentaList) {
            if (tipoCuenta.getId().equals(tipoCuentaId)) {
                tipo = tipoCuenta.getNombre();
            }
        }
        return tipo;
    }


    private Cliente getCliente(Long clienteId) {
        return clientesClientRest.detalleCliente(clienteId);
    }

}
