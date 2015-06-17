<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="../template/header.jsp"%>   
<h1>Alta de cliente</h1>
    <section id="contenedor">
        <section id="formulario">
            <form name="colegio" method="post" action="/Ej15_Github/Tienda/altaCliente" enctype="text/html">
                <h2>Datos de la tienda</h2>
                <div class="texto">
                    <label for="nombre" class="mano">Nombre</label>
                </div>
                <div class="elemento">
                    <input type="text" id="nombre" name="nombre" required/>
                </div>
                <div class="texto">
                    <label for="apellidos" class="mano">Apellidos</label>
                </div>
                <div class="elemento">
                    <input type="text" id="apellidos" name="apellidos" required/>
                </div>
                <div class="texto">
                    <label for="dni" class="mano">DNI</label>
                </div>
                <div class="elemento">
                    <input type="number" id="dni" name="dni" size=9 required/>
                </div>
                <br/><br/>
                
                <input type="submit" id="Enviar" class="mano" value="enviar">
                <input type="reset" id="Borrar" class="mano" value="borrar">
                
            </form>
        </section>
    </section>
 <%@include file="../template/footer.jsp"%>