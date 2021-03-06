package com.ite.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.clientes.modelo.beans.Evento;

@Repository
public class EventoImpl implements IntEvento {

	private List<Evento> listaEventos;

	public EventoImpl() {
		listaEventos = new ArrayList<Evento>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		IntTipoEvento iTipos = new TipoEventoImpl();
		
		listaEventos.add(new Evento(1, "Evento1", "Descripción E1", new Date(), 1, "Dirección E1", "Activo", "No", 150, 2, 50, 50, iTipos.findById(1)));
		listaEventos.add(new Evento(2, "Evento2", "Descripción E2", new Date(), 1, "Dirección E2", "En curso", "Sí", 700, 150, 100, 70, iTipos.findById(4)));
		listaEventos.add(new Evento(3, "Evento3", "Descripción E3", new Date(), 2, "Dirección E3", "Cancelado", "No", 200, 130, 100, 100, iTipos.findById(5)));
		listaEventos.add(new Evento(4, "Evento4", "Descripción E4", new Date(), 3, "Dirección E4", "Activo", "Sí", 350, 45, 170, 75, iTipos.findById(3)));
		listaEventos.add(new Evento(5, "Evento5", "Descripción E5", new Date(), 1, "Dirección E5", "Activo", "No", 150, 1, 50, 45, iTipos.findById(2)));
		listaEventos.add(new Evento(6, "Evento6", "Descripción E6", new Date(), 1, "Dirección E6", "Activo", "Sí", 150, 45, 50, 30, iTipos.findById(1)));
		listaEventos.add(new Evento(7, "Evento7", "Descripción E7", new Date(), 2, "Dirección E7", "Activo", "No", 150, 140, 50, 90, iTipos.findById(7)));
		listaEventos.add(new Evento(8, "Evento8", "Descripción E8", new Date(), 1, "Dirección E8", "Activo", "Sí", 150, 0, 50, 150, iTipos.findById(1)));		
		
	}

	@Override
	public Evento findById(int idEvento) {
		Evento evento = listaEventos.stream()
				.filter(ele -> idEvento == ele.getIdEvento())
				.findAny()
				.orElse(null);
		return evento;
	}

	@Override
	public List<Evento> findAll() {
		return listaEventos;
	}

	@Override
	public int insertarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEvento(int idEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
