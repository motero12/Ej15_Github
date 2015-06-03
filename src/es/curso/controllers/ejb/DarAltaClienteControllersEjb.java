package es.curso.controllers.ejb;

import es.curso.controllers.DarAltaClienteControllers;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class DarAltaClienteControllersEjb implements DarAltaClienteControllers{
	private ClienteDao clienteDao;
	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		// poner la logica del negocio para agregar un cliente
		// 1. verificar datos
		// 2. agregarlos ----> llamar a la capa dao ----> para dar de alta
		// 3. enviar e-mail al jefe
		// 4. enviar e-mail al cliente
		 clienteDao=new ClienteDaoJdbc();
		 clienteDao.create(cliente);
	}
	
}
