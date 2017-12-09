<%-- Trabalho PPW - SRS 1.0 --%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Reservar Salas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>

    </head>

    <body>

        <h1>Reservar</h1>
        <table class="tabelaListagem">

            <tr>
                <th>Id</th>
                <th>TipoSala</th>
                <th>Status</th>
                <th>Descricao</th>
                <th>Local</th>
                <th>EstadoConservacao</th>
                <th>Numero</th>
                <th>Data Reserva</th>
                <th>Reservar</th>
            </tr>

            <jsp:useBean id="servicos" scope="page" class="srs.servicos.SalaServices"/>

            <c:forEach items="${servicos.todosReserva}" var="sala">
                <tr>
                    <td>${sala.idSala}</td>
                    <td>${sala.tipoSala}</td>
                    <td>${sala.status}</td>
                    <td>${sala.descricao}</td>
                    <td>${sala.local}</td>
                    <td>${sala.estadoConservacao}</td>
                    <td>${sala.numero}</td>
                    <td>
                        <input id='data' name="dataReserva" type="text" size="15" value="" onkeyup="document.querySelector('#dataReservaHidden').value = this.value" onchange="document.querySelector('#dataReservaHidden').value = this.value" />
                        
                    </td>
                    <td>
                        <form method="GET" action="${pageContext.request.contextPath}/processaReservas">
                            <input type="hidden" name="idSala" value="${sala.idSala}">
                            <input type="hidden" name="acao" value="criar">
                            <input type="hidden" name="idUsuario" value="${usuarioId}">
                            <input type="hidden" name="dataReserva" id="dataReservaHidden" value="">
                            <input type="submit" value="Reservar">
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>

        <p><a href="${pageContext.request.contextPath}/menu.jsp">Tela Principal</a></p>

    </body>

</html>
