package com.devsu.servicio.clientes.domain.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Getter
@Builder
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;
}
