package com.curso.ecommerce.service;

import java.security.Principal;


import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class apic {
	
	public static final String PATH_FUNCIONARIOS_REGISTRO = "/public/validar_registro_funcionario";

	@RequestMapping(value = PATH_FUNCIONARIOS_REGISTRO, method = RequestMethod.GET, headers = "Accept="+MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String consultarFuncionarioPorId(ModelMap model, Principal principal)throws Exception {
	
		System.out.println("camilo");
		return "asdsa";
	}
	
		
}
