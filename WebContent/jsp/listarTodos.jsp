
<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Clientes</title>
<link rel="stylesheet" type="text/css" href="../css/estilos_formulario.css">
</head>
<body>
<h1><%=request.getAttribute("titulo")%></h1>
    <!-- tabla html dinamicamente -->
    
    <span><%=LocalDateTime.now()%></span>
    <span>valor enviado desde el Servlet Tienda IVA:</span>
    <span><%=(Integer)request.getAttribute("iva")%></span>
    <% ArrayList<Cliente> clientes=(ArrayList<Cliente>)request.getAttribute("clientes");%>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>DNI</th>
        </tr>
        <% for(Cliente c: clientes){ %>
            <tr>
                <td style="color:red;background-color:green;text-align:center"><%=c.getId() %></td>
                <td style="color:blue"><%=c.getNombres() %></td>
                <td><%=c.getApellidos() %></td>
                <td><%=c.getDni() %></td>
            </tr>
        <% } %>
        <!-- las siguientes tr se construyen dinamicamente -->
    </table>
</body>
</html>