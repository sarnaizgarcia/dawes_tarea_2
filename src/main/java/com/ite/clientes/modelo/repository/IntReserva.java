package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.Reserva;

public interface IntReserva {
	Reserva findById(int idReserva);
	List<Reserva> findAll();
	int insertarCliente(Reserva reserva);
	int modificarCliente(Reserva reserva);
	int eliminarCliente(Reserva reserva);
	int eliminarCliente(int idReserva);

}
