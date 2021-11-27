package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.TipoEvento;

public interface IntTipoEvento {
	
	TipoEvento findById(int idTipoEvento);
	List<TipoEvento> findAll();
	int insertarTipoEvento(TipoEvento tipoEvento);
	int modificarTipoEvento(TipoEvento tipoEvento);
	int eliminarTipoEvento(TipoEvento tipoEvento);
	int eliminarTipoEvento(int idTipoEvento);


}
