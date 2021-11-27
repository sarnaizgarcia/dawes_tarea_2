package com.ite.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.clientes.modelo.beans.Cliente;
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
		return "login";
	}
	
	@PostMapping("/login")
	public String inicioSesion(RedirectAttributes attr, Cliente cliente) {
		String emailUsuario = cliente.getEmailUsuario();
		String passwordUsuario = cliente.getPasswordUsuario();
		
		Cliente existeCliente = iCliente.findByEmail(emailUsuario);
		
		if (existeCliente != null) {
			if (passwordUsuario.equals(existeCliente.getPasswordUsuario())) {
				existeCliente.setEnabled(1);
				List<Evento> eventos = iEvento.findAll();
				attr.addFlashAttribute("eventos", "Muchos");
				return "redirect:/clientes/activos";
			} else {
				return "error-login";
			}
		} else {
			return "error-login";
		}
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model) {
		List<Evento> eventos = iEvento.findAll();
		model.addAttribute("eventos", eventos);
		return "activos";
	}

	@GetMapping("/error-login")
	public String errorLogin() {
		return "error-login";
	}
}
