package es.curso.dispatchers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.DarAltaClienteControllersEjb;
import es.curso.model.entity.Cliente;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/Tienda/*")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TiendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		switch(action){
			case "listarTodos":
				break;
			case "buscarPorNombre":
				break;
		}
		//redirigir hacia una vista jsp para mostrar los clientes
		
		RequestDispatcher rd;
		//enviar a la vista el resultado de la consulta a la base de datos
		rd=request.getRequestDispatcher("listarTodos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		switch(action){
		case "altaCliente":
			//recuperar los datos del formulario
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellidos");
			String dni=request.getParameter("dni");
			Cliente cliente=new Cliente(0,nombre, apellido, dni);
			DarAltaClienteControllersEjb controlador=new
					DarAltaClienteControllersEjb();
			controlador.agregar(cliente);
			break;
		
	}
	}

}
