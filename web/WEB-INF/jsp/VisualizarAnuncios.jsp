<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estiloAnuncio.css" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Anuncios</h1>
        <table border="none">
            <tbody>
                <th>ANUNCIO</th>
                <th>PUBLICADO POR</th>
                <th>FECHA PUBLICACION</th>
                <th>MENSAJE</th>
                <th>DETALLE</th>
            </tbody>
            
            <c:forEach items="${varia}" var="dato">
            <tr>
                <td>    
                    <h4><c:out value="${dato.getTitulo()}"></c:out></h4>
                </td>
                
                <td>    
                    <h4><c:out value="${dato.getUsuarios()}"></c:out></h4>
                </td>
                
                <td>    
                    <h4><c:out value="${dato.getFecha()}"></c:out></h4>
                </td>
                 <td>    
                    <h4><c:out value="${dato.getMensaje()}"></c:out></h4>
                </td>
                
                <td> 
                    <h5><a>Null</a></h5>
                </td>
                </c:forEach>
             </tr>
        </table>  
    </body>
</html>