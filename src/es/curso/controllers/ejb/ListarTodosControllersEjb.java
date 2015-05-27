package es.curso.controllers.ejb;

import java.util.ArrayList;

import es.curso.controllers.ListarTodosControllers;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class ListarTodosControllersEjb implements ListarTodosControllers{

	@Override
	public ArrayList<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		ClienteDaoJdbc daoCliente=new  ClienteDaoJdbc();
		ArrayList<Cliente> clientes=daoCliente.findAll();
		return clientes;
	}

}
