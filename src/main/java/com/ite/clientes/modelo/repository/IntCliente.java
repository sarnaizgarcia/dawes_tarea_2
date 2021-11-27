package com.ite.clientes.modelo.repository;

import java.util.List;

import com.ite.clientes.modelo.beans.Cliente;

public interface IntCliente {
	Cliente findById(int idCliente);
	Cliente findByEmail(String email);
	List<Cliente> findAll();
	int insertarCliente(Cliente cliente);
	int modificarCliente(Cliente cliente);
	int eliminarCliente(Cliente cliente);
	int eliminarCliente(int idCliente);


}
