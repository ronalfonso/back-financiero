package com.devsu.servicio.cuentas.specifications;

import com.devsu.servicio.cuentas.domain.entity.Cuenta;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Project servicio-cuentas
 * @Author raalf on 9/8/2024
 */
@And({
        @Spec(path = "id", params = "id", spec = Equal.class),
        @Spec(path = "numeroCuenta", params = "cuenta", spec = Equal.class),
        @Spec(path = "tipoCuenta", params = "tipo", spec = Equal.class),
})
public interface CuentasSpecification extends Specification<Cuenta> {
}
