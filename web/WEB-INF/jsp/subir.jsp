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
<h1 class="centrar-texto">Programaciones</h1>

        <table class="tabla" aling="center" border="1">
            <thead>
                <tr>
                    <th>Sigla</th>
                    <th>Nombre</th>
                    <th>Gestión</th>
                    <th>Subir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista.getLista()}" var="progra" >
                    <tr>
                        <td>    
                            <c:out value="${progra.getSigla()}"></c:out>
                            </td>

                            <td>    
                                <c:out value="${progra.getNombre()}"></c:out>
                            </td>
                            <td>    
                                <c:out value="${progra.getGestion()}"></c:out>
                            </td>
                            <td> 
                                <a href="<c:url value="subirarchivo.htm?id=${progra.getIdprog()}"/>">Subir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
