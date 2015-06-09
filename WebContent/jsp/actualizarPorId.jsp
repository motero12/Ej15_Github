<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Borrar por id</title>
<link rel="stylesheet" type="text/css" href="../css/estilos_formulario.css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/Tienda/actualizarPorId" name="actualizarPorId"> <!-- con # se queda en el mismo -->
    <label>Id:</label>
    <input type="text" name="id" id="id"/>
    <input type="submit" name="Actualizar" value="Buscar"/>
    <input type="reset" name="reiniciar" value="Cancelar"/>
    
</form>
</body>
</html>