<%-- 
    Trabalho PPW - SRS 1.0
    Created on : 17/11/2017, 22:05:16
    Author     : Laionel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SRS 1.0 - Sistema de Reservas de Salas</title>
    </head>
    <body>

        <h1>Login Sistema</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaUsuarios">
            <input name="acao" type="hidden" value="login"/>
            <table>
                <tr>
                    <td>Login:</td>
                    <td>
                        <input name="usuarioLogin" type="text" size="30"/>
                    </td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td>
                        <input name="senhaLogin" type="password" size="30"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita" colspan="2">
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <p class="erroLogin">${requestScope.msg}</p>
                    </td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
