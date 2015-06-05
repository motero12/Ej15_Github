package es.curso.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.controllers.ejb.BuscarPorNombreControllerEjb;
import es.curso.controllers.ejb.DarAltaClienteControllersEjb;
import es.curso.controllers.ejb.ListarTodosControllersEjb;
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
		String titulo="Sin titulo";
		RequestDispatcher rd;
		switch(action){
			case "altaCliente":
				rd=request.getRequestDispatcher("/html/AltaClienteView.html");
				rd.forward(request, response);
				break;
			case "listarTodos":
				titulo="listado general de clientes";
				ListarTodosControllersEjb todos=new ListarTodosControllersEjb();
				ArrayList<Cliente> clientes=todos.listarTodos();
				request.setAttribute("clientes", clientes);
				rd=request.getRequestDispatcher("/jsp/listarTodos.jsp");
				//redirigir hacia una vista jsp para mostrar los clientes
				request.setAttribute("titulo",titulo);
				//enviar a la vista el resultado de la consulta a la base de datos
				rd.forward(request, response);
				break;
			case "buscarPorNombre":	
//				titulo="resultado de la busqueda por nombre";
//				request.setAttribute("titulo",titulo);
//				rd=request.getRequestDispatcher("/jsp/listarTodos.jsp");
				rd = request.getRequestDispatcher("/jsp/buscarPorNombre.jsp");
				rd.forward(request, response);
				break;
			case "buscarPorId":
//				String cadenaId = request.getParameter("id");
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
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
			rd=request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
			break;
		case "buscarPorNombre":
			String cadenaNombre = request.getParameter("nombre");
			BuscarPorNombreControllerEjb controladorBusqueda=new BuscarPorNombreControllerEjb();
			controladorBusqueda.buscarPorNombre(cadenaNombre);
			//meter en el request el ArrayList de la respuesta
			ArrayList<Cliente> resultado=controladorBusqueda.buscarPorNombre(cadenaNombre);
			request.setAttribute("clientes",resultado);
			request.setAttribute("titulo","Busqueda por "+cadenaNombre);
			rd=request.getRequestDispatcher("/jsp/listarTodos.jsp");
			rd.forward(request, response);
			break;
		
		}
	}

}
