package com.devsu.servicio.clientes.domain.dto;

import com.devsu.servicio.clientes.domain.enums.Genero;
import lombok.Data;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Data
public class ClienteRequestDto {
    private String nombre;
    private Genero genero;
    private Long edad;
    private Integer identificacion;
    private String direccion;
    private String telefono;
    private String Contrasena;
}
