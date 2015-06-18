<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tienda</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos_formulario.css">
</head>
<body>
    <%response.setHeader("Cache-Control", "no-cache");//fuerza a la cache a obtener una nueva copia%>
    <%response.setHeader("Cache-Control", "no-store");%>
    <%response.setDateHeader("Expires",0);%>
    <%response.setHeader("Pragma", "no-cache");//HTTP 1.0 backward comptability%>
    <%HttpSession miSession=request.getSession(); %>
    <br/>
    <%if (miSession.getAttribute("userName")!=null) {%>
    <p>Usuario: <%=miSession.getAttribute("userName") %></p>
    <p>¡Hola <%=miSession.getAttribute("nombreCompleto") %>!</p>
    <p>Máximo periodo de inactividad: <%=miSession.getMaxInactiveInterval()%> segundos</p>
    <a href="${pageContext.request.contextPath}/Tienda/logout">Logout</a>
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/altaCliente">Alta de cliente</a>
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/listarTodos">Listar todos</a>
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/buscarPorNombre">Buscar por nombre</a>
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/actualizarPorId">Actualizar cliente</a>
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/buscarPorId">Borrar cliente</a>
    <%} else{%>
    <a href="${pageContext.request.contextPath}/Tienda/login">Login</a>
    <%}%>
    