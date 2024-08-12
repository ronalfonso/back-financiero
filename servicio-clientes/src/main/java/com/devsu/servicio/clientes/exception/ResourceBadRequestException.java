package com.devsu.servicio.clientes.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project clientes_ms
 * @Author raalf on 30/7/2024
 */
@Data
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException {

    private String errorCode;

    /**
     * ResourceBadRequestException
     *
     * @param message
     */
    public ResourceBadRequestException(String message) {
        super(message);
    }

    /**
     * ResourceBadRequestException
     *
     * @param message
     * @param errorCode
     */
    public ResourceBadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
