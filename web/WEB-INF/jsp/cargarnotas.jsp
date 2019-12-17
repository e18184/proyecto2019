<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/docente.css" type="text/css"/>
        <title>Cargar Notas</title>
    </head>
    <body>
        <h1 class="centrar-texto">&nbsp;Lista Estudiantes</h1>
        <div class="centrar">
            <div class="notas">
                <form:form action="cargarnotas.htm" method="POST" commandName="lista">
                    <table class="tabla" aling="center" border="0">
                        <thead>
                            <tr>
                                <th>Estudiante</th>
                                <th>Nota</th>
                            </tr>
                        </thead>

                        <c:forEach items="${lista.getLista()}" var="prog" >
                            <tr>
                                <td>   
                                    <span ><c:out value="${prog.getNombre()}" ></c:out></span>
                                    <span><c:out value="${prog.getAp()}"></c:out></span>
                                    <span><c:out value="${prog.getAm()}"></c:out></span>
                                    </td>

                                    <td>    
                                    <form:hidden value="${prog.getId_prog()}" path="id_prog"/>
                                    <form:input id="input-autosize" type="number" max="100" min="0" value="${prog.getNotafinal()}" path="notafinal"></form:input>
                                    </td>
                                </tr>
                        </c:forEach>
                        <c:set var="lista" value="l"/>
                    </table>

                    <br>
                    <br>
                    <div class="centrar">
                        <form:button type="submit" class="boton boton-aceptar">Aceptar</form:button>
                            <a href="listarmaterias.htm"><button type="button" class="boton boton-cancelar">Cancelar</button></a>
                        </div>
                </form:form>   
            </div>
        </div>
    </body>
</html>
