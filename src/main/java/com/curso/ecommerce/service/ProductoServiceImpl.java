package com.curso.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.repository.ProductoRepository;

public class ProductoServiceImpl implements ProductoService  {
	
	@Autowired
	private ProductoRepository productoR;

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productoR.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return productoR.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoR.save(producto);
		
	}

	@Override
	public void delate(Integer id) {
		// TODO Auto-generated method stub
		productoR.deleteById(id);
		
	}

}
