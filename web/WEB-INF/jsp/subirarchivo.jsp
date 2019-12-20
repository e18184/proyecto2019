<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="centrar-texto">Subir Archivo</h1>
        <div class="centrar">
            <div class="realizar-anuncio">

                <form:form action="subirarchivo.htm" method="POST" commandName="proyecto" enctype="multipart/form-data">
                    <form:input id="input-autosize" type="text" placeholder="Introduzca Título" path="titulo" required="required" onfocus="true"></form:input>
                        <br>
                        <br>
                    <form:textarea id="areatexto" placeholder="Introduzca Mensaje" path="resumen" rows="5" />
                    <br>
                    <br>
                    <form:input class="boton-file" type="file" path="archivo" accept="application/*"></form:input>
                        <br>
                        <br>
                    <form:checkbox id="boxanuncio" class="css-checkbox" path="estado"
                                   label ="Estado" checked="${proyecto.getEstado()?'checked':''}"/>
                    <br>
                    <br>
                    <div class="centrar">
                        <form:button class="boton boton-aceptar">Aceptar</form:button>
                            <a href="bottom.htm"><button type="button" class="boton boton-cancelar">Cancelar</button></a>
                        </div>
                </form:form>            
            </div>

        </div>    
    </body>
</html>
