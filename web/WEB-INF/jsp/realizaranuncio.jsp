<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form action="enviaranuncio.html" method="POST" commandName="anuncio">
                    <form:input placeholder="Introduzca Titulo" path="titulo"></form:input>
                        <br>
                        <br>
                    <form:textarea id="textarea" placeholder="Introduzca Mensaje" path="mensaje" rows="5" cols="32" />
                    <br>
                    <br>
                    <form:button>Aceptar</form:button>
                </form:form>            
            </div>

        </div>
    </body>
</html>
