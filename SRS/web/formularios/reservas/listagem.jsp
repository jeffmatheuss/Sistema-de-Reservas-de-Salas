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
        <title>Listagem Reservas</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Usuários Cadastrados</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/reservas/novo.jsp">Novo Usuário</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>CPF</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Departamento</th>
                    <th>Função</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

                <jsp:useBean id="servicos" scope="page" class="srs.servicos.ReservaServices"/>

                <c:forEach items="${servicos.todos}" var="reserva">
                    <tr>
                        <td>${reserva.idReserva}</td>
                        <td>${reserva.cpf}</td>
                        <td>${reserva.nome}</td>
                        <td>${reserva.sobrenome}</td>
                        <td>${reserva.departamento}</td>
                        <td>${reserva.funcao}</td>                        
                        <td><a href="${pageContext.request.contextPath}/processaReservas?acao=prepAlteracao&id=${reserva.idReserva}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaReservas?acao=prepExclusao&id=${reserva.idReserva}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/reservas/novo.jsp">Novo Usuário</a></p>
        
        <p><a href="${pageContext.request.contextPath}/menu.jsp">Tela Principal</a></p>

    </body>

</html>
