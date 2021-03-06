<%-- 
    Trabalho PPW - SRS 1.0
    Document   : Menu
    Created on : 17/11/2017, 22:05:16
    Author     : Laionel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioId}">
	<script>
		location.href='${pageContext.request.contextPath}/';
	</script>
</c:if>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SRS 1.0 - Sistema de Reservas de Salas</title>
    </head>
    <body>

        <h1>Sistema de Reservas de Salas</h1>

        <p>
            <a href="${pageContext.request.contextPath}/formularios/salas/listagem.jsp">Salas</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/usuarios/listagem.jsp">Usuários</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/formularios/reservas/listagem.jsp">Reservas</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/processaUsuarios?acao=logout">Logout</a>
        </p>
        <p>Logado como: ${nomeUsuario}</p>
    </body>
</html>
