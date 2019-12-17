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


                <table class="tabla" aling="center" border="0">
                    <thead>
                        <tr>
                            <th>Estudiante</th>
                            <th>Nota</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista.getLista()}" var="prog" >
                            <tr>
                                <td>    
                                    <c:out value="${prog.getNombre()}"></c:out>
                                    <c:out value="${prog.getAp()}"></c:out>
                                    <c:out value="${prog.getAm()}"></c:out>
                                    </td>

                                    <td>    
                                    <c:out value="${prog.getNotafinal()}"></c:out>
                                    </td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <br>
                <br>
                <div class="centrar">
                    <a href="listarmaterias.htm"><button type="button" class="boton boton-cancelar">Volver</button></a>
                </div>
            </div>
        </div>
    </body>
</html>

