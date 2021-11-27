package com.ite.clientes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.clientes.modelo.beans.Cliente;
import com.ite.clientes.modelo.beans.Evento;
import com.ite.clientes.modelo.repository.IntCliente;
import com.ite.clientes.modelo.repository.IntEvento;
import com.ite.clientes.modelo.repository.IntReserva;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {
	
	@Autowired
	private IntCliente iCliente;
	@Autowired
	private IntEvento iEvento;
	@Autowired
	private IntReserva iReserva;

	
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
				sesion.setAttribute("usuario", existeCliente);
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
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		usuario.setEnabled(0);
		return "cierre-sesion";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model, HttpSession sesion, RedirectAttributes attr) {
		List<Evento> eventos = iEvento.findAll();
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");

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
		model.addAttribute("eventos", eventos);
		return "destacados";
	}
	
	@GetMapping("/detalle/{id}")
	public String verDetalleEvento(@PathVariable("id") int idEvento, HttpSession sesion, Model model) {
		Evento evento = iEvento.findById(idEvento);
		model.addAttribute("evento", evento);
		// Si el evento existe
			// Coger los detalles de la reserva
			// Hacer un new de Reserva
			// Incluirlo con insertarReserva() de Reservas Imp;
			// Crear una reserva
			// Mostrar esa reserva

		
		return "detalle";
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
