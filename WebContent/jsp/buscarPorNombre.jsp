<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
    <form method="post" action="${pageContext.request.contextPath}/Tienda/buscarPorNombre" name="buscarPorNombre"> <!-- con # se queda en el mismo -->
    <label>Nombre:</label>
    <input type="text" name="nombre" id="nombre"/>
    <input type="submit" name="enviar" value="Enviar"/>
    <input type="reset" name="reiniciar" value="Reiniciar"/>
    
    </form>
<%@include file="../template/footer.jsp"%>