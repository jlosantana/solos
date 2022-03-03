<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="indexBean" class="br.com.cs2.solos.bean.IndexBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solos</title>
</head>
<body>
	<%
		Date dataAtual = new Date(); 
	%>
	<h1>
		<jsp:getProperty name="indexBean" property="mensagemDeBoasVindas" /> - <%=dataAtual %>
	</h1>
	<%
		String nomeUsuario = request.getParameter("nomeUsuario"); 
	%>
	
	<c:if test="<%=nomeUsuario != null%>">
		<h3>Nome do usuário enviado: <%=nomeUsuario %></h3>
	</c:if>
	
	<form action="index.jsp" method="get">
		<input name="nomeUsuario" />
		<button type="submit">Enviar</button>
	</form>
	
	<h1>Lista de Usuários</h1>
	
	<table border="1">
		<tr>
			<td>Nome</td>
		</tr>
		<c:forEach var="usuario" items="${indexBean.listaUsuarios}">
		    <tr>
		         <td>${usuario.nome}</td>
		    </tr>
		</c:forEach>
	</table>
</body>
</html>