<%-- Trabalho PPW - SRS 1.0 --%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty usuarioId}">
    <script>
        location.href = '${pageContext.request.contextPath}/';
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

        <h1>Excluir Reserva</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaReservas">

            <input name="acao" type="hidden" value="excluir"/>
            <input name="idReserva" type="hidden" value="${requestScope.reserva.idReserva}"/>

            <table>
                <tr>
                    <td class="alinharDireita">Id Reserva: </td>
                    <td>${requestScope.reserva.idReserva}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Usuário: </td>
                    <td>${requestScope.reserva.usuario.nome}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Departamento: </td>
                    <td>${requestScope.reserva.usuario.departamento}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Função: </td>
                    <td>${requestScope.reserva.usuario.funcao}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Número: </td>
                    <td>${requestScope.reserva.sala.numero}</td>
                </tr>
                <tr>
                    <td class="alinharDireita">Tipo Sala: </td>
                    <td>${requestScope.reserva.sala.tipoSala}</td> 
                </tr>
                <tr>
                    <td class="alinharDireita">Local: </td>
                    <td>${requestScope.reserva.sala.local}</td> 
                </tr>
                <tr>
                    <td class="alinharDireita">Data Reserva: </td>
                    <td>
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${requestScope.reserva.dataReserva}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/reservas/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Excluir"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
