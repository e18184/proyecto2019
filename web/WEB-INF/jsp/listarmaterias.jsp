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
        <h1 class="centrar-texto">Materias</h1>

        <table class="tabla" aling="center" border="0">
            <thead>
                <tr>
                    <th>Sigla</th>
                    <th>Nombre de la Materia</th>
                    <th>Gestión</th>
                    <th>Grupo</th>
                    <th>Registrar</th>
                    <th>Notas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lista.getLista()}" var="materia" >
                    <tr>
                        <td>    
                            <c:out value="${materia.getSigla()}"></c:out>
                            </td>

                            <td>    
                                <c:out value="${materia.getMateria()}"></c:out>
                            </td>
                            <td>    
                                <c:out value="${materia.getGestion()}"></c:out>
                            </td>
                            <td>    
                                <c:out value="${materia.getGrupo()}"></c:out>
                            </td>
                            <td> 
                                <a href="<c:url value="cargarnotas.htm?id=${materia.getId_grupo()}"/>">Editar Notas</a>
                        </td>
                        <td> 
                            <a href="<c:url value="visualizarnotas.htm?id=${materia.getId_grupo()}"/>">Ver Notas</a>
                        </td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
