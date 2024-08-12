package com.devsu.servicio.clientes.specification;

import com.devsu.servicio.clientes.domain.entity.Cliente;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@And({
        @Spec(path = "id", params = "id", spec = Equal.class),
        @Spec(path = "nombre", params = "nombre", spec = LikeIgnoreCase.class),
})
public interface ClienteSpecification extends Specification<Cliente> {
}
