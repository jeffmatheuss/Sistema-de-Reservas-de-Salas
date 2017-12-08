<%-- 
--%>

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
        <title>Listagem Reservas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Usuários Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/reservas/novo.jsp">Reservar</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuário</th>
                    <th>Departamento</th>
                    <th>Função</th>
                    <th>Numero Sala</th>
                    <th>Tipo Sala</th>
                    <th>Local</th>
                    <th>Data Reserva</th>
                    <th>Cancelar</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="srs.servicos.ReservaServices"/>

                <c:forEach items="${servicos.todos}" var="reserva">
                    <tr>
                        <td>${reserva.idReserva}</td>
                        <td>${reserva.usuario.nome}</td>
                        <td>${reserva.usuario.departamento}</td>
                        <td>${reserva.usuario.funcao}</td>
                        <td>${reserva.sala.numero}</td>
                        <td>${reserva.sala.tipoSala}</td>
                        <td>${reserva.sala.local}</td>
                        <td>
                            <fmt:formatDate pattern="dd/MM/yyyy" value="${reserva.dataReserva}"/>
                        </td>
                        <td><a href="${pageContext.request.contextPath}/processaReservas?acao=prepExclusao&id=${reserva.idReserva}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/reservas/novo.jsp">Reservar</a></p>

        <p><a href="${pageContext.request.contextPath}/menu.jsp">Tela Principal</a></p>

    </body>

</html>
