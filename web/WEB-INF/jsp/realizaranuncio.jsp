<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/docente.css" type="text/css"/>
        <title>Realizar Anuncio</title>
    </head>
    <body>
        <h1 class="centrar-texto">Crear un Nuevo Anuncio!</h1>
        <div class="centrar">
            <div class="realizar-anuncio">

                <form:form action="realizaranuncio.htm" method="POST" commandName="anuncio" enctype="multipart/form-data">
                    <form:input id="input-autosize" placeholder="Introduzca Titulo" path="titulo"></form:input>
                        <br>
                        <br>
                    <form:textarea id="areatexto" placeholder="Introduzca Mensaje" path="mensaje" rows="5" />
                    <br>
                    <br>
                    <form:label path="fecha">Fecha de Emision</form:label>
                    <c:set var="now" value="<%=new java.util.Date()%>" />
                    <fmt:formatDate var="fechasp" pattern="dd/MM/yyyy" value="${now}" />
                    <form:input id="fecha-input" path="fecha" value="${fechasp}" disabled="true"></form:input>
                    <form:hidden path="fecha" value="${fechasp}"/>
                        <br>
                        <br>
                    <form:input type="file" path="archivo"></form:input>
                        <br>
                        <br>
                    <form:checkbox id="idanuncio" path="estado" value="${anuncio.getIdanuncio()}" label="Habilitado"
                                   checked="${anuncio.getEstado()?'checked':''}"/>
                    <br>
                    <br>
                    <div class="centrar">
                        <form:button class="boton-aceptar">Aceptar</form:button>
                        </div>
                </form:form>            
            </div>

        </div>
    </body>
</html>
