<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- incluir header.jsp -->
    <%@include file="template/header.jsp" %>
<h1>LOGIN</h1>
<form method="post" action="${pageContext.request.contextPath}/Tienda/login" name="login"> <!-- con # se queda en el mismo -->
    <label>Usuario:</label>
    <input type="text" name="userName" id="userName"/>
    <br>
    <label>Contraseña:</label>
    <input type="password" name="password" id="password" type="password"/>
    <br><br>
    <input type="submit" name="login" value="Login"/>
    <input type="reset" name="reiniciar" value="Cancelar"/>
</form>
    <!-- incluir footer.jsp -->
    <%@include file="template/footer.jsp" %>