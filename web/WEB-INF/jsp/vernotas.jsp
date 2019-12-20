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
<h1 class="centrar-texto">Lista Notas</h1>

        <table class="tabla" aling="center" border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Materia</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista.getLista()}" var="notas" >
                    <tr>
                        <td>    
                            <c:out value="${notas.getUsuario()}"></c:out>
                            </td>
                        <td>    
                            <c:out value="${notas.getNombre()}"></c:out>
                            </td>

                            <td>    
                                <c:out value="${notas.getNota()}"></c:out>
                            </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
