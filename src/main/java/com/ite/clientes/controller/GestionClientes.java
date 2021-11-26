package com.ite.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.clientes.modelo.repository.IntCliente;
import com.ite.clientes.modelo.repository.IntEvento;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {
	
	@Autowired
	private IntCliente iCliente;
//	@Autowired
//	private IntEvento iEvento;
	
	@GetMapping("/login")
	public String acceso() {
		System.out.println(iCliente.findAll().toString());
		return "login";
	}

}
