package com.devsu.servicio.clientes.mappers;


import com.devsu.servicio.clientes.domain.dto.ClienteActualizarRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteRequestDto;
import com.devsu.servicio.clientes.domain.dto.ClienteResponseDTO;
import com.devsu.servicio.clientes.domain.entity.Cliente;

import java.util.Date;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
public class ClienteMapper {

    public static ClienteResponseDTO toClienteResponseDTO(Cliente cliente) {
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .contrasena(cliente.getContrasena())
                .estado(cliente.getEstado())
                .build();
    }

//    public static Cliente toPersona(ClienteResponseDTO personaRequest) {
//        return Cliente.builder()
//                .nombre(personaRequest.getNombre())
//                .genero(personaRequest.getGenero())
//                .edad(personaRequest.getEdad())
//                .identificacion(personaRequest.getIdentificacion())
//                .direccion(personaRequest.getDireccion())
//                .telefono(personaRequest.getTelefono())
//                .build();
//    }

    public static Cliente requestToPersona(ClienteRequestDto personaRequest) {
        Date now = new Date();
        return Cliente.builder()
                .nombre(personaRequest.getNombre())
                .genero(personaRequest.getGenero())
                .edad(personaRequest.getEdad())
                .identificacion(personaRequest.getIdentificacion())
                .direccion(personaRequest.getDireccion())
                .telefono(personaRequest.getTelefono())
                .clienteId((int) now.getTime())
                .contrasena(personaRequest.getContrasena())
                .estado(true)
                .build();
    }

    public static Cliente actualizarRequestDtoToPersona(ClienteActualizarRequestDto personaRequest) {
        return Cliente.builder()
                .nombre(personaRequest.getNombre())
                .genero(personaRequest.getGenero())
                .edad(personaRequest.getEdad())
                .identificacion(personaRequest.getIdentificacion())
                .direccion(personaRequest.getDireccion())
                .telefono(personaRequest.getTelefono())
                .contrasena(personaRequest.getContrasena())
                .estado(personaRequest.getEstado() == null || personaRequest.getEstado())
                .build();
    }
}
