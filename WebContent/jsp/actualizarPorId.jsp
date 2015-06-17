<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<form method="post" action="${pageContext.request.contextPath}/Tienda/actualizarPorId" name="actualizarPorId"> <!-- con # se queda en el mismo -->
    <label>Id:</label>
    <input type="text" name="id" id="id"/>
    <input type="submit" name="Actualizar" value="Buscar"/>
    <input type="reset" name="reiniciar" value="Cancelar"/>
    
</form>
<%@include file="../template/footer.jsp"%>