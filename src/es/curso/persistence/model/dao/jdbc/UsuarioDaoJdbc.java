package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import es.curso.model.entity.Usuario;
import es.curso.persistence.model.dao.UsuarioDao;

public class UsuarioDaoJdbc implements UsuarioDao{
	
	private Connection cx;
	
	@Override
	public Usuario searchForUserNamePassword(String userName, String password) {
		// TODO Auto-generated method stub
		// usuario se inicializa a null porque si no lo encuentra,
		// el return usuario devolvera null
		Usuario usuario=null;
		try {
			abrirConexion();
			PreparedStatement ps=cx.prepareStatement("Select * from usuario where userName= ?"
					+ "and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet consulta=ps.executeQuery();
			if(consulta.next()){
				usuario=new Usuario();
				usuario.setId(consulta.getInt("id"));
				usuario.setNombres(consulta.getString("nombre"));
				usuario.setApellidos(consulta.getString("apellido"));
				usuario.setUserName(consulta.getString("username"));
				usuario.setPassword(consulta.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
			}
		return usuario;
	}
	
	private void abrirConexion(){
		//determinar si tengo el driver a conectar(de mysql)
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//establecer la conexion
			cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","rootTienda","rootTienda");
		//iniciar el autoCommit en false
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cerrarConexion(){
		try {
			if(cx!=null)
			cx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
