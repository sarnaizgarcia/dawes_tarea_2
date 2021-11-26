package com.ite.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.clientes.modelo.beans.TipoEvento;

@Repository
public class TipoEventoImpl implements IntTipoEvento {
	
	private List<TipoEvento> listaTipoEventos;
	
	public TipoEventoImpl() {
		listaTipoEventos = new ArrayList<TipoEvento>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		listaTipoEventos.add(new TipoEvento(1, "Concierto", "Conciertos de los buenos"));
		listaTipoEventos.add(new TipoEvento(2, "Despedida", "Fiesta de las buenas"));
		listaTipoEventos.add(new TipoEvento(3, "Cumpleaños", "Felicidades"));
		listaTipoEventos.add(new TipoEvento(4, "Boda", "Con lo que saquen de esto se compran un coche"));
		listaTipoEventos.add(new TipoEvento(5, "Mitin político", "No te creas nada"));
		listaTipoEventos.add(new TipoEvento(6, "Convención", "Entérate de algo"));
		listaTipoEventos.add(new TipoEvento(7, "Conferencia", "No te aburras"));

	}

	@Override
	public TipoEvento findById(int idTipoEvento) {
		TipoEvento tipoEvento = listaTipoEventos.stream()
				.filter(ele -> idTipoEvento == ele.getIdTipo())
				.findAny()
				.orElse(null);
		return tipoEvento;
	}

	@Override
	public List<TipoEvento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarCliente(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarCliente(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(TipoEvento tipoEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarCliente(int idTipoEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
