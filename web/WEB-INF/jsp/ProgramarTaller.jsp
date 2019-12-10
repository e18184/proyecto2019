<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Progrmar un Taller </h1>
        
        <table border="1">
            <tbody>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Modificar</th>
                <th>Borrar</th>
                <th>Programar Taller</th>
            </tbody>
            <tr>
                <td>    
                    <h1><c:out value="${dato.getNombre()}"></c:out></h1>
                </td>
                
                <td>    
                    <h1><c:out value="${dato.getApellido1()}"></c:out></h1>
                </td>
                 <td>    
                    <h1><c:out value="${dato.getNombreApellido2()}"></c:out></h1>
                </td>
                
                <td> 
                    <h5><a href="<c:url value="modificarhijo.html?ci=${dato.getCi()}"/>">Modificar</a></h5>
                </td>
                <td> 
                    <h5><a href="<c:url value="borrarmadre.html?ci=${dato.getCi()}"/>">Borrar</a></h5>
                </td>
                <td> 
                    <h5><a href="<c:url value="listarmascota.html?ci=${dato.getCi()}"/>">Programars</a></h5>
                </td>
             </tr>
        </table>  
                
</html>
