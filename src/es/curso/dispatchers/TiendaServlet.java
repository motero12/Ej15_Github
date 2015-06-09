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

import es.curso.controllers.ejb.ActualizarPorIdControllerEjb;
import es.curso.controllers.ejb.BuscarPorIdControllerEjb;
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
		//hay que ponerle el substring(1) porque lo que recupera
		//con el getPathInfo, por ejemplo, en el caso de borrarCliente
		//es /buscarPorId y la barra debe ser quitada, para que
		//sea entendida por el switch, es decir, en el switch la action
		//se llama buscarPorId. Sin embargo, desde index.html se envía
		//como /buscarPorId
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
				rd = request.getRequestDispatcher("/jsp/buscarPorId.jsp");
				rd.forward(request, response);
				break;
			case "actualizarPorId":
				rd = request.getRequestDispatcher("/jsp/actualizarPorId.jsp");
				rd.forward(request, response);
				break;
//				String cadenaId = request.getParameter("id");
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
		case "buscarPorId":
			int id = Integer.parseInt(request.getParameter("id"));
			BuscarPorIdControllerEjb eliminarEjb=new BuscarPorIdControllerEjb();
			eliminarEjb.eliminar(id);
			//al poner sendRedirect lo que hace es salirse de este servlet y
			//volver a relanzarlo, en este caso, con listarTodos
			response.sendRedirect("listarTodos");
			break;
		case "actualizarPorId":
			int idActual = Integer.parseInt(request.getParameter("id"));
			ActualizarPorIdControllerEjb actualizarEjb=new ActualizarPorIdControllerEjb();
			actualizarEjb.buscar(idActual);
			Cliente clienteUpdate=new Cliente();
			clienteUpdate=actualizarEjb.buscar(idActual);
			request.setAttribute("cliente",clienteUpdate);
			String titulo;
			titulo="Consulta de cliente";
			request.setAttribute("titulo", titulo);
			rd=request.getRequestDispatcher("/jsp/ConsultaCliente.jsp");
			rd.forward(request, response);
			break;
		case "updatePorId":
			int idUpdate = Integer.parseInt(request.getParameter("id"));
			String nombreUpdate=request.getParameter("nombre");
			String apellidosUpdate=request.getParameter("apellidos");
			String dniUpdate=request.getParameter("dni");
			Cliente clienteUpdates=new Cliente(idUpdate,nombreUpdate, apellidosUpdate, dniUpdate);
			ActualizarPorIdControllerEjb updateEjb=new ActualizarPorIdControllerEjb();
			updateEjb.actualizar(clienteUpdates);
			rd=request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
			break;
		}
	}

}
