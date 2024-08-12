package com.devsu.servicio.clientes.models.service;

import java.util.List;

import com.devsu.servicio.clientes.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
