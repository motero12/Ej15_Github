
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
<script type="text/javascript">
function enviar(boton){
	var formulario=document.getElementById("formulario"+boton.name.substring(3));
	// alterar el action de acuerdo con el boton pulsado
	if(activar==0){
		
	}
	if(boton.value=="Actualizar")
		formulario.action="${pageContext.request.contextPath}/Tienda/buscarPorId";
	    formulario.submit();
	    
}
</script>
</head>
<body>
<h1><%=request.getAttribute("titulo")%></h1>
    <!-- tabla html dinamicamente -->
    
    <span><%=LocalDateTime.now()%></span>
    <% ArrayList<Cliente> clientes=(ArrayList<Cliente>)request.getAttribute("clientes");%>
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>DNI</th>
        </tr>
        <% for(Cliente c: clientes){ %>
        <form id="formulario<%=c.getId()%>" action="$(pageContext.request.contextPath)/Tienda/buscarPorId" 
            method="post" onsubmit="return false;">
            <%byte activar=0;%>
            <tr id="<%=c.getId()%>">
                <td style="color:red;background-color:green;text-align:center"> 
                    <%=c.getId() %></td>  
                <td style="color:blue"><input type="text" name="nombre" value="<%=c.getNombres() %>"></td>
                <td><input type="text" name="apellidos" value="<%=c.getApellidos() %>"></td>
                <td><input type="text" name="dni" value="<%=c.getDni() %>"></td>
                <td><input class="btnSinBordes" 
                   type="submit" value="Editar"
                     name="btn<%= c.getId()%>" onclick="enviar(this);"/> 
                </td>
                <td><input class="btnSinBordes" 
                   type="submit" value="Actualizar" disabled="disabled"
                     name="btn<%= c.getId()%>" onclick="enviar(this);"/> 
                </td>
               <td><input class="btnSinBordes" 
                   type="submit" value="Eliminar" disabled="disabled"
                     name="btn<%= c.getId()%>" onclick="enviar(this);"/> 
                     
               </td>
            </tr>
        </form>
        <% } %>
        <!-- las siguientes tr se construyen dinamicamente -->
    </table>
</body>
</html>