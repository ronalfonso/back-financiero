package com.devsu.servicio.clientes.domain.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Slf4j
@Getter
public enum Genero {

    MASCULINO("MASCULINO"),
    FEMENINO("FEMENINO"),
    OTROS("OTROS");

    private final String value;

    Genero(String value) {
        this.value = value;
    }

}
