package com.devsu.servicio.cuentas.clients;

import com.devsu.servicio.cuentas.domain.entity.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Project cuentas_ms
 * @Author raalf on 1/8/2024
 */
@FeignClient(name = "servicio-clientes")
public interface ClientesClientRest {

    @GetMapping("/clientes/{id}")
    Cliente detalleCliente(@PathVariable("id") Long id);


}
