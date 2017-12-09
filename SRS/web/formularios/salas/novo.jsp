<%-- Trabalho PPW - SRS 1.0 --%>

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
        <title>Nova Sala</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css"/>
    </head>

    <body>

        <h1>Nova Sala</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/processaSalas">

            <input name="acao" type="hidden" value="criar"/>

            <table>
                <tr>
                    <td class="alinharDireita">Tipo de Sala:</td>
                    <td>
                        <input name="tipoSala" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Status:</td>
                    <td>
                        <select name="status">
                            <option>Disponível</option>
                            <option>Reservada</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td>
                        <input name="descricao" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Local:</td>
                    <td>
                        <input name="local" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Estado de Conservação:</td>
                    <td>
                        <input name="estadoConservacao" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Número:</td>
                    <td>
                        <input name="numero" type="text" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/formularios/salas/listagem.jsp">Voltar</a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>

</html>
