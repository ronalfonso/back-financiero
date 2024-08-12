package com.devsu.servicio.clientes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.devsu.servicio.clientes.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
