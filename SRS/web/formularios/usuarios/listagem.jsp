<%-- Trabalho PPW - SRS 1.0 --%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty usuarioId}">
	<script>
		location.href='${pageContext.request.contextPath}/';
	</script>
</c:if>
<!DOCTYPE HTML">

<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
        <h1>Lista de Usuários</h1>

        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>

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

                <jsp:useBean id="servicos" scope="page" class="srs.servicos.UsuarioServices"/>

                <c:forEach items="${servicos.todos}" var="usuario">
                    <tr>
                        <td>${usuario.idUsuario}</td>
                        <td>${usuario.cpf}</td>
                        <td>${usuario.nome}</td>
                        <td>${usuario.sobrenome}</td>
                        <td>${usuario.departamento}</td>
                        <td>${usuario.funcao}</td>                        
                        <td><a href="${pageContext.request.contextPath}/processaUsuarios?acao=prepAlteracao&id=${usuario.idUsuario}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaUsuarios?acao=prepExclusao&id=${usuario.idUsuario}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>
        
        <p><a href="${pageContext.request.contextPath}/menu.jsp">Tela Principal</a></p>

    </body>

</html>
