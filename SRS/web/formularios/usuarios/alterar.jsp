<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuário</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Alterar Cliente</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaReservas">

            <input name="acao" type="hidden" value="alterar"/>
            <input name="idReserva" type="hidden" value="${requestScope.reserva.idReserva}"/>

            <table>
                <tr>
                    <td class="alinharDireita">CPF:</td>
                    <td>
                        <input name="cpf" type="text" size="13" value="${requestScope.reserva.cpf}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Nome:</td>
                    <td>
                        <input name="nome" type="text" size="20" value="${requestScope.reserva.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Sobrenome:</td>
                    <td>
                        <input name="sobrenome" type="text" size="20" value="${requestScope.reserva.sobrenome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Departamento:</td>
                    <td>
                        <input name="departamento" type="text" size="20" value="${requestScope.reserva.departamento}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Função:</td>
                    <td>
                        <input name="funcao" type="text" size="20" value="${requestScope.reserva.funcao}"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Senha:</td>
                    <td>
                        <input name="senha" type="text" size="20" value="${requestScope.reserva.senha}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/reservas/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Alterar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
