package es.curso.controllers.ejb;

import es.curso.controllers.BuscarPorIdController;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BuscarPorIdControllerEjb implements BuscarPorIdController{
	@Override
	public void eliminar(int id){
		// TODO Auto-generated method stub
		ClienteDao clienteDao=new ClienteDaoJdbc();
		clienteDao.delete(id);
		//mandar un correo al usuario diciendo que esta borrado
	}
}
