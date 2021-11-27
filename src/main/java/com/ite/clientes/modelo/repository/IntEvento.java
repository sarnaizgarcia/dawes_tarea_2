package com.ite.clientes.modelo.repository;


import java.util.List;

import com.ite.clientes.modelo.beans.Evento;

public interface IntEvento {
	Evento findById(int idEvento);
	List<Evento> findAll();
	int insertarEvento(Evento evento);
	int modificarEvento(Evento evento);
	int eliminarEvento(Evento evento);
	int eliminarEvento(int idEvento);

}
