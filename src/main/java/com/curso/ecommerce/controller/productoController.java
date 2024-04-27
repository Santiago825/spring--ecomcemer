package com.curso.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.ecommerce.model.Producto;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class productoController {
	private final Logger LOGGER =LoggerFactory.getLogger(productoController.class);
	
	@Autowired
	private ProductoService productoService;
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("ESTE ES EL OBJETO PRODUCTO {}",producto.toString());
		Usuario u =new Usuario();
		u.setId(1);
		producto.setUsuario(u);
		productoService.save(producto);

		return "redirect:/productos";
	}
}
