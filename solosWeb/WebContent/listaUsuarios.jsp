<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Usuários</title>
</head>
<body>
	<f:view>
	
		<h:dataTable var="usuario" value="#{listaUsuariosBean.listaUsuarios}" width="100%" border="1">
			<h:column>
				<f:facet name="header">
		            <h:outputText value="Nome" />
		        </f:facet>
				<h:outputText value="#{usuario.nome}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
		            <h:outputText value="CPF" />
		        </f:facet>
				<h:outputText value="#{usuario.cpf}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
		            <h:outputText value="Login" />
		        </f:facet>
				<h:outputText value="#{usuario.login}"></h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header">
		            <h:outputText value="Senha" />
		        </f:facet>
				<h:outputText value="#{usuario.senha}"></h:outputText>
			</h:column>
		</h:dataTable>

	</f:view>
</body>
</html>