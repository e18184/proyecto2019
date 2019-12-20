<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Programar.css" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Programa Un Curso</h1>
        <table border="none">
            <tbody>
                <th>Nombre</th>
                <th>Sigla</th>
                <th>Grupo</th>
                <th>Desprogramar</th>
                <th>Programar</th>
            </tbody>
            
            <c:forEach items="${variable}" var="dato">
            <tr>
                <td>    
                    <h4><c:out value="${dato.getNombre()}"></c:out></h4>
                </td>
                
                <td>    
                    <h4><c:out value="${dato.getSigla()}"></c:out></h4>
                </td>
                
                <td>    
                    <h4><c:out value="${dato.getGrupo()}"></c:out></h4>
                </td>
                                
                <td> 
                    <h5><a href="eliminarProgramacion.htm">Eliminar</a></h5>
                </td>
                <td> 
                    <h5><a href="formProgramar.htm?id=${dato.getId_grupo()}">Programar</a></h5>
                </td>
                
                
                
                </c:forEach>
             </tr>
        </table>  
    </body>
</html>
    