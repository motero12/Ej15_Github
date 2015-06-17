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
    <br/>
    <a href="${pageContext.request.contextPath}/Tienda/login">Login</a>
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
