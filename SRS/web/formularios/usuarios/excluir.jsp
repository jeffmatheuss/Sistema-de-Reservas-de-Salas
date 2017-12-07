<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Usuário</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir Usuário</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaUsuarios">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="idUsuario" type="hidden" value="${requestScope.usuario.idUsuario}"/>

            <table>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        ${requestScope.usuario.cpf}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        ${requestScope.usuario.nome}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        ${requestScope.usuario.sobrenome}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Departamento:</td>
                    <td>
                        ${requestScope.usuario.departamento}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Função:</td>
                    <td>
                        ${requestScope.usuario.funcao}"
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Senha:</td>
                    <td>
                        ${requestScope.usuario.senha}
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/usuarios/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
