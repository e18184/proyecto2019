<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/docente.css" type="text/css"/>
        <title>Realizar Anuncio</title>
        <script>
            $(function fecha() {
                $("#date").datepicker(); // give your date field an id or a date css class
            });
        </script>
    </head>
    <body>
        <h1 class="centrar-texto">Crear un Nuevo Anuncio!</h1>
        <div class="centrar">
            <div class="realizar-anuncio">

                <form:form action="realizaranuncio.htm" method="POST" commandName="anuncio">
                    <form:input id="input-autosize" placeholder="Introduzca Titulo" path="titulo"></form:input>
                        <br>
                        <br>
                    <form:textarea id="textarea" placeholder="Introduzca Mensaje" path="mensaje" rows="5" cols="32" />
                    <br>
                    <br>
                    <form:label path="fecha">Fecha de Emision</form:label>
                        <br>
                    <form:input id="input-autosize" placeholder="Fecha" value="18/11/2019" path="fecha"></form:input>
                        <br>
                        <br>
                    <form:label path="fecha">Subir Archivo</form:label>
                        <button id="examinar" type="button">Examinar</button>
                        <br>
                    <form:input id="input-autosize" placeholder="ruta archivo" value="archivo.pdf" path="archivo" disabled="true"></form:input>
                        <br>
                        <br>
                    <form:checkbox id="idanuncio" path="estado" value="${anuncio.getIdanuncio()}" label="Habilitado"
                                   checked="${anuncio.getEstado()?'checked':''}"/>
                    <br>
                    <br>
                    <div class="centrar">
                        <form:button>Aceptar</form:button>
                        </div>
                </form:form>            
            </div>

        </div>
    </body>
</html>
