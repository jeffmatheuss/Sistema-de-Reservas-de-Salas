<%-- 
    Document   : listagem
    Created on : 18/01/2011, 14:26:29
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML">

<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários Cadastrados</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>
        
<<<<<<< HEAD
        <h1>Usuários Cadastrados</h1>
=======
        <h1>Lista de Usuarios</h1>
>>>>>>> 0209ca567cfbaf13ef7a14684ef3daf821ccae0c

        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>

        <table class="tabelaListagem">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Departamento</th>
                    <th>CPF</th>
                    <th>Função</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>

<<<<<<< HEAD
                <jsp:useBean id="servicos" scope="page" class="cadastroclientes.servicos.ClienteServices"/>

                <c:forEach items="${servicos.todos}" var="cliente">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.sobrenome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.cidade.nome}</td>
                        <td><a href="${pageContext.request.contextPath}/processaClientes?acao=prepAlteracao&id=${cliente.id}">Alterar</a></td>
                        <td><a href="${pageContext.request.contextPath}/processaClientes?acao=prepExclusao&id=${cliente.id}">Excluir</a></td>
=======
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
>>>>>>> 0209ca567cfbaf13ef7a14684ef3daf821ccae0c
                    </tr>
                </c:forEach>
            </tbody>
        </table>

<<<<<<< HEAD
        <p><a href="${pageContext.request.contextPath}/formularios/clientes/novo.jsp">Novo Cliente</a></p>
=======
        <p><a href="${pageContext.request.contextPath}/formularios/usuarios/novo.jsp">Novo Usuário</a></p>
>>>>>>> 0209ca567cfbaf13ef7a14684ef3daf821ccae0c
        
        <p><a href="${pageContext.request.contextPath}/index.jsp">Tela Principal</a></p>

    </body>

</html>
