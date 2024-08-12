package com.devsu.servicio.clientes.infrastructure;

import com.devsu.servicio.clientes.application.ClienteService;
import com.devsu.servicio.clientes.domain.dto.ClienteActualizarRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteResponseDTO;
import com.devsu.servicio.clientes.domain.entity.Cliente;
import com.devsu.servicio.clientes.domain.repository.CLienteRepository;
import com.devsu.servicio.clientes.domain.repository.PersonaRepository;
import com.devsu.servicio.clientes.exception.ResourceBadRequestException;
import com.devsu.servicio.clientes.exception.ResourceNotFoundException;
import com.devsu.servicio.clientes.helpers.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static com.devsu.servicio.clientes.mappers.ClienteMapper.requestToPersona;
import static com.devsu.servicio.clientes.mappers.ClienteMapper.toClienteResponseDTO;


/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final PersonaRepository personaRepository;

    private final CLienteRepository cLienteRepository;


    @Override
    public Page<Cliente> obtenerTodo(Specification<Cliente> spec, Pageable pageable) {
        return cLienteRepository.findAll(spec, pageable);
    }

    @Override
    public ClienteResponseDTO obtenerPorId(Long id) {
        return toClienteResponseDTO(cLienteRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro un cliente con el id: " + id))
        );
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDto cliente) {
        if (indentificacionExiste(cliente.getIdentificacion())) {
            throw new ResourceBadRequestException("La indentificacion ya existe");
        }
        return toClienteResponseDTO(
                cLienteRepository.save(requestToPersona(cliente))
        );
    }

    @Override
    public ClienteResponseDTO actualizarCliente(Long id, ClienteActualizarRequestDto cliente) {
        if (!personaExiste(id)) {
            throw new ResourceBadRequestException("El cliente con ese el id: "+ id+" no existe");
        }
        Cliente clienteParaActualizar = cLienteRepository.findById(id)
                .orElseThrow(() -> new ResourceBadRequestException("El cliente con ese el id: "+ id+" no existe"));

        clienteParaActualizar.setNombre(cliente.getNombre());
        clienteParaActualizar.setGenero(cliente.getGenero());
        clienteParaActualizar.setEdad(cliente.getEdad());
        clienteParaActualizar.setIdentificacion(cliente.getIdentificacion());
        clienteParaActualizar.setDireccion(cliente.getDireccion());
        clienteParaActualizar.setTelefono(cliente.getTelefono());
        clienteParaActualizar.setContrasena(cliente.getContrasena());
        clienteParaActualizar.setEstado(cliente.getEstado() == null ? true : cliente.getEstado());

        return toClienteResponseDTO(
                cLienteRepository.save(clienteParaActualizar)
        );
    }

    @Override
    public Message eliminarCliente(Long id) {
        if (!personaExiste(id)) {
            throw new ResourceBadRequestException("El cliente con ese el id: "+ id+" no existe");
        }
        cLienteRepository.deleteById(id);
        return new Message("Cliente eliminada con éxito");
    }

    private boolean personaExiste(Long id) {
        return personaRepository.existsById(id);
    }

    private boolean indentificacionExiste(Integer indentificacion) {
        return personaRepository.existsByIdentificacion(indentificacion);
    }
}
