package com.ite.clientes.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ite.clientes.modelo.beans.Cliente;

@Repository
public class ClienteImpl implements IntCliente {
	
	private List<Cliente> listaClientes;
	
	public ClienteImpl() {
		listaClientes = new ArrayList<Cliente>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		listaClientes.add(new Cliente(1, "presi", "PSOE", "pedro@mail.com", "Pedro Sánchez", "Ferraz, 70", new Date()));
		listaClientes.add(new Cliente(2, "pablo", "PP", "pablo@mail.com", "Pablo Casado", "Génova, 13", new Date()));
	}

	@Override
	public Cliente findById(int idCliente) {
		Cliente cliente = listaClientes.stream()
				.filter(ele -> idCliente == ele.getIdUsuario())
				.findAny()
				.orElse(null);
		return cliente;
	}
	
	@Override
	public Cliente findByEmail(String email) {
		Cliente cliente = listaClientes.stream()
				.filter(ele -> email.equals(ele.getEmailUsuario()))
				.findAny()
				.orElse(null);
		return cliente;
	}

	@Override
	public List<Cliente> findAll() {
		return listaClientes;
	}

	@Override
	public int insertarCliente(Cliente cliente) {
		if (listaClientes.contains(cliente))
			return 0;
		else
			return listaClientes.add(cliente) ? 1 : 0;
	}

	@Override
	public int modificarCliente(Cliente cliente) {
		int pos = listaClientes.indexOf(cliente);
		if (pos == -1)
			return 0;
		else
			return (listaClientes.set(pos, cliente) != null) ? 1 : 0;
	}

	@Override
	public int eliminarCliente(Cliente cliente) {
		return listaClientes.remove(cliente) ? 1 : 0;
	}

	@Override
	public int eliminarCliente(int idCliente) {
		Cliente aux = new Cliente();
		aux.setIdUsuario(idCliente);		
		int pos = listaClientes.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (listaClientes.remove(pos) !=null) ? 1 : 0;
	}

}
