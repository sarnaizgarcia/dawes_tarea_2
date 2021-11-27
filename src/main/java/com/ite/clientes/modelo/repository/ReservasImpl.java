package com.ite.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.clientes.modelo.beans.Reserva;

@Repository
public class ReservasImpl implements IntReserva {
	
	private List<Reserva> listaReservas;
	
	public ReservasImpl() {
		listaReservas = new ArrayList<Reserva>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		IntEvento iEvento = new EventoImpl();
		IntCliente iCliente = new ClienteImpl();
		
		listaReservas.add(new Reserva(iEvento.findById(1).getIdEvento(), iCliente.findById(1).getIdUsuario(), 1000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(2).getIdEvento(), iCliente.findById(1).getIdUsuario(), 2000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(3).getIdEvento(), iCliente.findById(1).getIdUsuario(), 3000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(4).getIdEvento(), iCliente.findById(1).getIdUsuario(), 4000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(5).getIdEvento(), iCliente.findById(2).getIdUsuario(), 1000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(6).getIdEvento(), iCliente.findById(2).getIdUsuario(), 2000, "Poco que observar", 9));
		listaReservas.add(new Reserva(iEvento.findById(7).getIdEvento(), iCliente.findById(2).getIdUsuario(), 3000, "Poco que observar", 9));
	}

	@Override
	public Reserva findById(int idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reserva> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarCliente(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarCliente(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(int idReserva) {
		// TODO Auto-generated method stub
		return 0;
	}

}
