<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuários</title>
</head>
<body>
	<f:view>
		<h1>
			<h:outputText value="Cadastro de Usuários" />
		</h1>
		<h:form>
			<h:outputText value="Nome" />
			<h:inputText value="#{cadastroUsuariosBean.nome}" />
			<h:commandButton value="Salvar" action="#{cadastroUsuariosBean.salvarUsuario}" />
		</h:form>
	</f:view>
</body>
</html>