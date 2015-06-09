package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{
	private Connection cx;
	
	@Override
	public void create(Cliente cliente) {
		try {
		// TODO Auto-generated method stub
		// 1. instrucciones para conectar con base de datos
			abrirConexion();
		// 2. preparar sentencias para agregar
			PreparedStatement ps=cx.prepareStatement("insert into cliente values(?,?,?,?)");
		// insertar los datos del cliente en las ?
			ps.setInt(1, 0);
			ps.setString(2, cliente.getNombres());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDni());
		// 3. ejecutar la sentencia sql	
		// executeUpdate se usa para insert, delete y update
		// esta instruccion devuelve como resultado el
		// numero de filas afectadas
		
			ps.executeUpdate();
		// hacer commit
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		// 4. cerrar la conexion al ponerlo en finally
		// siempre se ejecuta
			cerrarConexion();
		}
		
	}

	public ClienteDaoJdbc() {
		super();
	}

	@Override
	public ArrayList<Cliente> findAll() {
//		clientes.add(new Cliente(1, "Jose","Perez","12345"));
//		clientes.add(new Cliente(2, "Maria","Sanchez","23456"));
//		clientes.add(new Cliente(3, "Manuel","Lopez","34567"));
//		clientes.add(new Cliente(4, "Dolores","Garcia","45678"));
//		clientes.add(new Cliente(5, "Roberto","Gonzalez","56789"));
//		clientes.add(new Cliente(6, "Eva","Ricart","67890"));
//		clientes.add(new Cliente(7, "Alberto","Jimenez","78901"));
//		clientes.add(new Cliente(8, "Silvia","Barcelona","89012"));
//		clientes.add(new Cliente(9, "Jorge","Cuart","90123"));
//		clientes.add(new Cliente(10, "Teresa","Madrid","01234"));
//		// TODO Auto-generated method stub
//		return clientes;
		
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		try {
		// 1 abrir la conexion
			abrirConexion();
		// 2 prepara la sentencia
			PreparedStatement ps= cx.prepareStatement("select * from cliente");
		// 3 ejecutar la sentencia
			ResultSet consulta=ps.executeQuery();
		// Al ejecutarse esta instruccion se posiciona antes del primer elemento
		// 3-1 traspasar los datos de la respuesta al arrayList
			while(consulta.next()){
				Cliente clienteTemporal=new Cliente();
				clienteTemporal.setId(consulta.getInt("id"));
				clienteTemporal.setNombres(consulta.getString("nombres"));
				clienteTemporal.setApellidos(consulta.getString("apellidos"));
				clienteTemporal.setDni(consulta.getString("dni"));
				clientes.add(clienteTemporal);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		// 4 cerrar la conexion
			cerrarConexion();
		}
		return clientes;
	}
	private void abrirConexion(){
		//determinar si tengo el driver a conectar(de mysql)
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//establecer la conexion
			cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/Tienda","rootTienda","rootTienda");
		//iniciar el autoCommit en false
//			cx.setAutoCommit(false);
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
	//@Override
	public ArrayList<Cliente> searchByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		try {
			// 1. establecer la conexion
			abrirConexion();
			// 2. preparar las sentencias sql parametrizadas
			PreparedStatement ps= cx.prepareStatement("select * from cliente where nombres like ?");
			// 2.1 especificar lo que va en ?
			ps.setString(1, "%"+name+"%");
			// 3. ejecutar la query
			ResultSet resultado=ps.executeQuery();
			while(resultado.next()){
				Cliente c=new Cliente();
				c.setId(resultado.getInt("id"));
				c.setNombres(resultado.getString("nombres"));
				c.setApellidos(resultado.getString("apellidos"));
				c.setDni(resultado.getString("dni"));
				clientes.add(c);
			}
			
			// 3.1 pasar los datos del Resultset hacia el ArrayList
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally{
			  cerrarConexion();
		}
		// 4. cerrar la conexion
		return clientes;
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			abrirConexion();
			PreparedStatement ps= cx.prepareStatement("update cliente set nombres= ?,"
					+ " apellidos=?, dni=?"
					+ "where id =?");
			ps.setString(1, cliente.getNombres());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getDni());
			ps.setInt(4, cliente.getId());
			ps.executeUpdate();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		// 1. establecer la conexion
		try {
			abrirConexion();
		// 2. preparar las sentencias sql parametrizadas
			PreparedStatement ps= cx.prepareStatement("delete from cliente where id =?");
		// insertar el dato del cliente en la ?
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			// 4. cerrar la conexion al ponerlo en finally
			// siempre se ejecuta
				cerrarConexion();
		}
	}

	@Override
	public Cliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente=new Cliente();
		try {
			abrirConexion();
		// 2. preparar las sentencias sql parametrizadas
			PreparedStatement ps= cx.prepareStatement("select * from cliente where id =?");
		// insertar el dato del cliente en la ?
			ps.setInt(1, id);
			ResultSet consulta=ps.executeQuery();
			while(consulta.next()){
				cliente.setId(consulta.getInt("id"));
				cliente.setNombres(consulta.getString("nombres"));
				cliente.setApellidos(consulta.getString("apellidos"));
				cliente.setDni(consulta.getString("dni"));
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
		return cliente;
	}
}
