package es.curso.controllers.ejb;

import es.curso.controllers.ActualizarPorIdController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class ActualizarPorIdControllerEjb implements ActualizarPorIdController{

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		ClienteDao clienteDao=new ClienteDaoJdbc();
		clienteDao.update(cliente);
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		ClienteDao clienteDao=new ClienteDaoJdbc();
		return clienteDao.buscarId(id);
	}
}
