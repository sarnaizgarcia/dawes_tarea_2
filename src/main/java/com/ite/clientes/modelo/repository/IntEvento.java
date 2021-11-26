package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.Evento;

public interface IntEvento {
	Evento findById(int idEvento);
	List<Evento> findAll();
	int insertarCliente(Evento evento);
	int modificarCliente(Evento evento);
	int eliminarCliente(Evento evento);
	int eliminarCliente(int idEvento);

}
