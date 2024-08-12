package com.devsu.servicio.clientes.domain.repository;

import com.devsu.servicio.clientes.domain.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project clientes_ms
 * @Author raalf on 29/7/2024
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    boolean existsByIdentificacion(Integer indentificacion);

}
