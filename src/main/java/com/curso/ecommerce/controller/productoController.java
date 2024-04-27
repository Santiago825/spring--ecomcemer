package com.curso.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String show(Model model) {
		model.addAttribute("productos",productoService.getAll());
		
		return "productos/show";
	}
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable Integer id,Model model) {
		Producto producto =new Producto();
		Optional<Producto> optionalProducto =productoService.get(id);
		producto=optionalProducto.get();
		LOGGER.info("ESTE ES EL OBJETO PRODUCTO {}",producto.toString());
		model.addAttribute("producto",producto);
		return "productos/edit";
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
	@PostMapping("/update")
	public String update(Producto producto) {
		LOGGER.info("ESTE ES EL OBJETO PRODUCTO {}",producto.toString());;
		productoService.update(producto);
		return "redirect:/productos";
	}
	@GetMapping("/delate/{id}")
	public String delate(@PathVariable Integer id) {

		productoService.delate(id);
		return "redirect:/productos";
	}
}
