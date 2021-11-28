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

	/**
	 * Muestra la vista del login en /clientes/login
	 * @return la vista para iniciar sesión
	 */
	@GetMapping("/login")
	public String acceso() {
		return "login";
	}
	
	/**
	 * Procesa el login del usuario
	 * Comprueba si existe un usuario con esos atributos (emaily password)
	 * Si existe, crea un atributo de sesión con el usuario
	 * Y redirige la vista a la /clientes/activos
	 * Si el usuario no existe, redirige a una vista de error 
	 * @param cliente: es el cliente que ha iniciado sesión
	 * @param sesion: es la instancia de la sesión
	 * @return la pantalla de incio después del login con los eventos activos
	 */
	@PostMapping("/login")
	public String inicioSesion(Cliente cliente, HttpSession sesion) {
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
	
	/**
	 * Elimina al usuario de la sesión y la finaliza
	 * @param model: instancia de Model 
	 * @param sesion: es la instancia de la sesión
	 * @return la vista de cierre de sesión
	 */
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(Model model, HttpSession sesion) {
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		return "cierre-sesion";
	}
	
	/**
	 * Muestra los eventos activos
	 * Obtiene un listado de los eventos y comprueba si el usuario existe
	 * Si es así, crea un atributo con los eventos y dirige la vista a /clientes/activos
	 * Si no, muestra un error
	 * @param model: instancia de Model
	 * @param sesion: es la instancia de la sesión
	 * @return la vista de los eventos activos
	 */
	@GetMapping("/activos")
	public String mostrarActivos(Model model, HttpSession sesion) {
		List<Evento> eventos = iEvento.findAll();
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");

		if (usuario.getEnabled() == 1 && usuario != null) {
			model.addAttribute("eventos", eventos);
			return "activos";
		} else {
			return "error";
		}
	}
	
	/**
	 * Muestra los eventos destacados
	 * @param model: instancia de Model
	 * @return la vista de los eventos destacados
	 */
	@GetMapping("/destacados")
	public String mostrarDestacados(Model model) {
		List<Evento> eventos = iEvento.findAll();
		model.addAttribute("eventos", eventos);
		return "destacados";
	}
	
	/**
	 * Muestra el detalle del evento que se pasa por URLPath
	 * @param idEvento
	 * @param model
	 * @return una vista del detalle del evento en /clientes/detalle/{id}
	 */
	@GetMapping("/detalle/{id}")
	public String verDetalleEvento(@PathVariable("id") int idEvento, Model model) {
		Evento evento = iEvento.findById(idEvento);
		model.addAttribute("evento", evento);
		return "detalle";
	}
	
	@PostMapping("/detalle/reservar/{id}")
	public String hacerReserva(Reserva reserva, @PathVariable(name = "id") int idEvento, HttpSession sesion, Model model, RedirectAttributes attr) {
		
		Evento evento = iEvento.findById(idEvento);
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		model.addAttribute("evento", evento);
		model.addAttribute("reserva", reserva);

		if (reserva != null && reserva.getCantidad() != null) {
			reserva.setIdEvento(idEvento);
			reserva.setIdUsuario(usuario.getIdUsuario());
			reserva.setPrecioReserva(evento.getPrecio() * (reserva.getCantidad() == null ? 0 : reserva.getCantidad()));
			iReserva.insertarReserva(reserva);
			attr.addFlashAttribute("reserva", reserva);
			return "redirect:/clientes/reservar/{id}";
		} else {
			return "error-reserva";
		}
	}

	@GetMapping("/reservar/{id}")
	public String mostrarReserva(@PathVariable("id") int idEvento, HttpSession sesion, Reserva reserva, Model model) {
		Cliente usuario = (Cliente) sesion.getAttribute("usuario");
		Evento evento = iEvento.findById(idEvento);
		model.addAttribute("evento", evento);
		return "exito-reserva";
	}

	/**
	 * Muestra una vista de error si el login es incorrecto
	 * @return error en el login en clientes/login
	 */
	@GetMapping("/error-login")
	public String errorLogin() {
		return "error-login";
	}
	
	/**
	 * Devuelve una vista en caso de que haya un error no controlado
	 * @return
	 */
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
