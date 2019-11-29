<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Principal</title>
        <link rel="stylesheet" href="css/principal.css" type="text/css"/>
    </head>
    <body>
        <table  class="tabla" border="0" align="center">
            <tr>
                <td class="banner">
                    <iframe class="top" name="top" src="${pageContext.request.contextPath}/top.htm" ></iframe>
                </td>
            </tr>
            <tr>
                <td>
                    <table width="100%">
                        <tr valign="top">
                            <td width="200" background="images/bg2.jpg">
                                <iframe class="noborder" id="principal" name="principal" src="${pageContext.request.contextPath}/principal_2.htm" witdh="30%" height="700"></iframe>
                            </td>
                            <td >
                                <iframe class="noborder" id="bottom" name="bottom" src="${pageContext.request.contextPath}/bottom.htm" height="700" width="100%"></iframe>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="center">&copy; Taller 1 Grupo 2 UAJMS</td>
            </tr>
        </table>
    </body>
</html>