<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../template/header.jsp"%>
<h1><%=request.getAttribute("titulo")%></h1>
<%Cliente cliente=new Cliente(); %>
<%cliente=(Cliente)request.getAttribute("cliente"); %>
<section id="contenedor">
        <section id="formulario">
            <form name="colegio" method="post" action="/Ej15_Github/Tienda/updatePorId" enctype="text/html">
                <h2>Datos del cliente</h2>
                <div class="texto">
                    <label for="id" class="mano">Id</label>
                </div>
                <div class="elemento">
                    <input type="text" id="id" name="id" value="<%=cliente.getId()%>"/>
                </div>
                <div class="texto">
                    <label for="nombre" class="mano">Nombre</label>
                </div>
                <div class="elemento">
                    <input type="text" id="nombre" name="nombre" value="<%=cliente.getNombres()%>"/>
                </div>
                <div class="texto">
                    <label for="apellidos" class="mano">Apellidos</label>
                </div>
                <div class="elemento">
                    <input type="text" id="apellidos" name="apellidos" value="<%=cliente.getApellidos()%>"/>
                </div>
                <div class="texto">
                    <label for="dni" class="mano">DNI</label>
                </div>
                <div class="elemento">
                    <input type="number" id="dni" name="dni" value="<%=cliente.getDni()%>"/>
                </div>
                <br/><br/>
                
                <input type="submit" id="Actualizar" class="mano" value="Actualizar">
                <input type="reset" id="Borrar" class="mano" value="Borrar">
                
            </form>
        </section>
    </section>
<%@include file="../template/footer.jsp"%>