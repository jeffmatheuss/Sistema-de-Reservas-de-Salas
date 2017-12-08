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
        <title>Reservar Salas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Reservar</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/salas/novo.jsp">Nova Sala</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>TipoSala</th>
                    <th>Status</th>
                    <th>Descricao</th>
                    <th>Local</th>
                    <th>EstadoConservacao</th>
                    <th>Numero</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="srs.servicos.SalaServices"/>

                <c:forEach items="${servicos.todos}" var="sala">
                    <tr>
                        <td>${sala.idSala}</td>
                        <td>${sala.tipoSala}</td>
                        <td>${sala.status}</td>
                        <td>${sala.descricao}</td>
                        <td>${sala.local}</td>
                        <td>${sala.estadoConservacao}</td>
                        <td>${sala.numero}</td>
                        <td><a href="${pageContext.request.contextPath}/processaSalas?acao=prepAlteracao&id=${sala.idSala}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaSalas?acao=prepExclusao&id=${sala.idSala}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/salas/novo.jsp">Nova Sala</a></p>
        
        <p><a href="${pageContext.request.contextPath}/menu.jsp">Tela Principal</a></p>

    </body>

</html>
