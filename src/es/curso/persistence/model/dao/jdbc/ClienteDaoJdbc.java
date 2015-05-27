package es.curso.persistence.model.dao.jdbc;

import java.util.ArrayList;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{
	private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	@Override
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub
		// 1. instrucciones para conectar con base de datos
		// 2. preparar sentencias para agregar
		// 3. ejecutar la sentencia sql
		// 4. cerrar la conexion
	}

	@Override
	public ArrayList<Cliente> findAll() {
		clientes.add(new Cliente(1, "Jose","Perez","12345"));
		clientes.add(new Cliente(2, "Maria","Sanchez","23456"));
		clientes.add(new Cliente(3, "Manuel","Lopez","34567"));
		clientes.add(new Cliente(4, "Dolores","Garcia","45678"));
		clientes.add(new Cliente(5, "Roberto","Gonzalez","56789"));
		clientes.add(new Cliente(6, "Eva","Ricart","67890"));
		clientes.add(new Cliente(7, "Alberto","Jimenez","78901"));
		clientes.add(new Cliente(8, "Silvia","Barcelona","89012"));
		clientes.add(new Cliente(9, "Jorge","Cuart","90123"));
		clientes.add(new Cliente(10, "Teresa","Madrid","01234"));
		// TODO Auto-generated method stub
		return clientes;
	}

}
