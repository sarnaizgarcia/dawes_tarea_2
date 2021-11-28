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
import com.ite.clientes.modelo.beans.Reserva;
import com.ite.clientes.modelo.repository.IntCliente;
import com.ite.clientes.modelo.repository.IntEvento;
import com.ite.clientes.modelo.repository.IntReserva;

@Controller
@RequestMapping("/clientes")
public class GestionClientes {
	// Pedimos que busque la clase que implementa estas interfaces,
	// crea una instancia de esas implementaciones y pasa la referencia
	// del objeto a las variables declaradas.
	@Autowired
	private IntCliente iCliente;
	@Autowired
	private IntEvento iEvento;
	@Autowired
	private IntReserva iReserva;

	/*
	 * Muestra la vista de login
	 */
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
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		return "cierre-sesion";
	}
	
	@GetMapping("/activos")
	public String mostrarActivos(Model model, HttpSession sesion, RedirectAttributes attr) {
		List<Evento> eventos = iEvento.findAll();
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");

		if (usuario.getEnabled() == 1 && usuario != null) {
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
	public String verDetalleEvento(@PathVariable("id") int idEvento, Model model) {
		System.out.println("verDetalleEvento");
		Evento evento = iEvento.findById(idEvento);
		model.addAttribute("evento", evento);
		return "detalle";
	}
	
	@PostMapping("/detalle/reservar/{id}")
	public String hacerReserva(Reserva reserva, @PathVariable("id") int idEvento, HttpSession sesion, Model model, RedirectAttributes attr) {
		System.out.println("hacerReserva");
		Evento evento = iEvento.findById(idEvento);
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		model.addAttribute("evento", evento);
		model.addAttribute("reserva", reserva);

		if (reserva.getCantidad() == 0) {
			model.addAttribute("mensajeError", "Tienes que indicar una cantidad para hacer la reserva.");
			return "redirect:/clientes/reservar/{id}";
		} else if (reserva != null) {
			reserva.setIdEvento(idEvento);
			reserva.setIdUsuario(usuario.getIdUsuario());
			reserva.setPrecioReserva(evento.getPrecio() * reserva.getCantidad());
			iReserva.insertarReserva(reserva);
			attr.addFlashAttribute("reserva", reserva);
			return "redirect:/clientes/reservar/{id}";
		} else {
			return "error-reserva";
		}
	}

	@GetMapping("/reservar/{id}")
	public String mostrarReserva(@PathVariable("id") int idEvento, HttpSession sesion, Reserva reserva, Model model) {
		System.out.println("mostrarReserva");
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		Evento evento = iEvento.findById(idEvento);
		model.addAttribute("evento", evento);
		return "exito-reserva";
	}
	
//	@GetMapping("/error-reserva")
//	public String errorReserva() {
//		return "error-reserva"; // Falla
//	}
	
	@GetMapping("/error-login")
	public String errorLogin() {
		return "error-login";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
