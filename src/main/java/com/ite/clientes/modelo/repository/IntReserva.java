package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.Reserva;

public interface IntReserva {
	Reserva findById(int idReserva);
	List<Reserva> findAll();
	int insertarReserva(Reserva reserva);
	int modificarReserva(Reserva reserva);
	int eliminarReserva(Reserva reserva);
	int eliminarReserva(int idReserva);

}
