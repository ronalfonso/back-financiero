package com.devsu.servicio.clientes.application;

import com.devsu.servicio.clientes.domain.dto.ClienteActualizarRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteResponseDTO;
import com.devsu.servicio.clientes.domain.entity.Cliente;
import com.devsu.servicio.clientes.helpers.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
public interface ClienteService {

    Page<Cliente> obtenerTodo(Specification<Cliente> spec, Pageable pageable);

    ClienteResponseDTO obtenerPorId(Long id);

    ClienteResponseDTO crearCliente(ClienteRequestDto persona);

    ClienteResponseDTO actualizarCliente(Long id, ClienteActualizarRequestDto persona);

    Message eliminarCliente(Long id);
}
