package es.curso.controllers.ejb;

import es.curso.controllers.LoginController;
import es.curso.model.entity.*;
import es.curso.persistence.model.dao.UsuarioDao;
import es.curso.persistence.model.dao.jdbc.UsuarioDaoJdbc;

public class LoginControllerEjb implements LoginController {

	@Override
	public Usuario login(String userName, String password) {
		// TODO Auto-generated method stub
		UsuarioDao usuarioDao=new UsuarioDaoJdbc();
		
		return usuarioDao.searchForUserNamePassword(userName, password);
	}

}
