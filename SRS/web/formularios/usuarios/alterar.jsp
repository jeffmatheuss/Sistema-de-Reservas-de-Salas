<%-- Trabalho PPW - SRS 1.0 --%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioId}">
	<script>
		location.href='${pageContext.request.contextPath}/';
	</script>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuário</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Usuário</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaUsuarios">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="idUsuario" type="hidden" value="${requestScope.usuario.idUsuario}"/>

            <table>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        <input name="cpf" type="text" size="13" value="${requestScope.usuario.cpf}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20" value="${requestScope.usuario.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        <input name="sobrenome" type="text" size="20" value="${requestScope.usuario.sobrenome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Departamento:</td>
                    <td>
                        <input name="departamento" type="text" size="20" value="${requestScope.usuario.departamento}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Função:</td>
                    <td>
                        <input name="funcao" type="text" size="20" value="${requestScope.usuario.funcao}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Senha:</td>
                    <td>
                        <input name="senha" type="text" size="20" value="${requestScope.usuario.senha}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/usuarios/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
