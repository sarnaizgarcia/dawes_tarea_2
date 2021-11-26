package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.TipoEvento;

public interface IntTipoEvento {
	
	TipoEvento findById(int idTipoEvento);
	List<TipoEvento> findAll();
	int insertarCliente(TipoEvento tipoEvento);
	int modificarCliente(TipoEvento tipoEvento);
	int eliminarCliente(TipoEvento tipoEvento);
	int eliminarCliente(int idTipoEvento);


}
