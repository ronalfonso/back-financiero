package com.devsu.servicio.clientes.interfaces;

import com.devsu.servicio.clientes.application.ClienteService;
import com.devsu.servicio.clientes.domain.dto.ClienteActualizarRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteResponseDTO;
import com.devsu.servicio.clientes.domain.entity.Cliente;
import com.devsu.servicio.clientes.helpers.Message;
import com.devsu.servicio.clientes.specification.ClienteSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/listar")
    public Page<Cliente> obtenerTodos(ClienteSpecification spec, Pageable pageable) {
        return clienteService.obtenerTodo(spec, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> detalle(@PathVariable Long id) {
        return new ResponseEntity<ClienteResponseDTO>(clienteService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ClienteResponseDTO> crear(@RequestBody ClienteRequestDto personaRequestDto) {
        return new ResponseEntity<ClienteResponseDTO>(clienteService.crearCliente(personaRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizar(@PathVariable Long id, ClienteActualizarRequestDto personaRequestDto) {
        return new ResponseEntity<ClienteResponseDTO>(clienteService.actualizarCliente(id, personaRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> eliminar(@PathVariable Long id) {
        return new ResponseEntity<Message>(clienteService.eliminarCliente(id), HttpStatus.OK);
    }
}
