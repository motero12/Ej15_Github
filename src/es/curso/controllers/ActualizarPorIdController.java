package es.curso.controllers;

import es.curso.model.entity.Cliente;

public interface ActualizarPorIdController {
	public Cliente buscar(int id);
	public void actualizar(Cliente cliente);
}
