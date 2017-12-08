<%-- 
--%>

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
        <title>Excluir Reserva</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Excluir Usuário</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaReservas">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="idUsuario" type="hidden" value="${requestScope.reserva.idUsuario}"/>

            <table>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        ${requestScope.reserva.cpf}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        ${requestScope.reserva.nome}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        ${requestScope.reserva.sobrenome}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Departamento:</td>
                    <td>
                        ${requestScope.reserva.departamento}
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Função:</td>
                    <td>
                        ${requestScope.reserva.funcao}"
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Senha:</td>
                    <td>
                        ${requestScope.reserva.senha}
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/reserva/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
