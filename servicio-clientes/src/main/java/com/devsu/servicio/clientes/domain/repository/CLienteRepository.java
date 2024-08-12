package com.devsu.servicio.clientes.domain.repository;

import com.devsu.servicio.clientes.domain.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project clientes_ms
 * @Author raalf on 30/7/2024
 */
@Repository
public interface CLienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAll(Specification<Cliente> spec, Pageable pageable);

}
