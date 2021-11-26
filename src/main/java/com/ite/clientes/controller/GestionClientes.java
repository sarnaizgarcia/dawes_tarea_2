package com.ite.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ite.clientes.modelo.beans.Evento;
import com.ite.clientes.modelo.repository.IntCliente;
import com.ite.clientes.modelo.repository.IntEvento;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {
	
	@Autowired
	private IntCliente iCliente;
	@Autowired
	private IntEvento iEvento;
	
	@GetMapping("/login")
	public String acceso() {
		System.out.println(iCliente.findAll().toString());
		return "login";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
		System.out.println("EO");

		List<Evento> eventos = iEvento.findAll();
		System.out.println(eventos);
		model.addAttribute("eventos", eventos);
		// Pintar los eventos activos en la vista activos
		return "activos";
	}

}
