package com.ite.clientes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

//	@GetMapping("/")
//	public String principal() {
//		return "principal";
//	}
	
	@GetMapping("/login")
	public String acceso() {
		return "login";
	}
	
	@PostMapping("/login")
	public String inicioSesion(RedirectAttributes attr, Cliente cliente, HttpSession sesion) {
		String emailUsuario = cliente.getEmailUsuario();
		String passwordUsuario = cliente.getPasswordUsuario();
		
		Cliente existeCliente = iCliente.findByEmail(emailUsuario);
		
		if (existeCliente != null) {
			if (passwordUsuario.equals(existeCliente.getPasswordUsuario())) {
				existeCliente.setEnabled(1);
//				List<Evento> eventos = iEvento.findAll();
//				attr.addFlashAttribute("eventos", eventos);
				sesion.setAttribute("usuario", existeCliente);
//				attr.addFlashAttribute("usuario", existeCliente);
				return "redirect:/clientes/activos";
			} else {
				return "error-login";
			}                                              
		} else {
			return "error-login";
		}
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model, HttpSession sesion) {
		// porque no puedo obtener aquí los atributos del usuario?
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		usuario.setEnabled(0);
		return "cierre-sesion";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model, HttpSession sesion, RedirectAttributes attr) {
		List<Evento> eventos = iEvento.findAll();
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		System.out.println(usuario.toString());
		if (usuario.getEnabled() == 1) {
			model.addAttribute("eventos", eventos);
			return "activos";
		} else {
			return "error";
		}
	}
	
	@GetMapping("/destacados")
	public String mostrarDestacados(Model model) {
		List<Evento> eventos = iEvento.findAll();
		// porque no puedo obtener aquí los atributos del usuario?
		model.addAttribute("eventos", eventos);
		return "";
	}

	@GetMapping("/error-login")
	public String errorLogin() {
		return "error-login";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
