
<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
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
            <th>Editar</th>
            <th>Actualizar</th>
            <th>Borrar</th>
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
    <%@include file="../template/footer.jsp"%>