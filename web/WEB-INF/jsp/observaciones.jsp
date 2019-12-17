<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/docente.css" type="text/css"/>
        <title>Realizar Obervaciones</title>
    </head>
    <body>
        <h1 class="centrar-texto">Crear una Nueva Observacion!</h1>
        <div class="centrar">
            <div class="realizar-anuncio">

                <form:form action="observaciones.htm" method="POST" commandName="observaciones" enctype="multipart/form-data">

                    <form:label path="fecha">Fecha de Emisión</form:label>
                    <c:set var="now" value="<%=new java.util.Date()%>" />
                    <fmt:formatDate var="fechasp" pattern="dd/MM/yyyy" value="${now}" />
                    <form:input id="fecha-input" path="fecha" value="${fechasp}" disabled="true"></form:input>
                    <form:hidden path="fecha" value="${fechasp}"/>
                    <br>
                    <br>
                    <form:input class="boton-file" type="file" path="archivo" accept="application/*"></form:input>
                        <br>
                        <br>
                    <form:textarea id="areatexto" placeholder="Introduzca Mensaje" path="observacion" rows="5" required="required"/>

                    <br>
                    <br>
                    <form:label path="lista">Etapas</form:label>
                    <c:forEach items="${observaciones.getLista()}" var="et">    
                    <form:radiobutton checked="${cuntry.lang == 'FR' ? 'checked':''}" path="idetapa" value="${et.getID()}" label="${et.getNombre()}" required="required"/>
                    </c:forEach>
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