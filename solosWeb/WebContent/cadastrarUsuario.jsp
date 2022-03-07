<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuários</title>
</head>
<body>
	<div class="container">
		<f:view>
			<h:form>
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
							aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">SOLOS</a>
					</div>
			
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>						
								<h:commandLink value="Lista de Usuários" action="listaUsuarios" />						
							</li>
							<li class="active"><a href="#">Novo Usuário <span class="sr-only">(current)</span></a></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> 
				</nav>
			</h:form>
			<h1>
				<h:outputText value="Cadastro de Usuários" />
			</h1>
			<h:form>
				<div class="form-group">
			    	<label for="nome">Nome</label>
			    	<h:inputText id="nome" value="#{cadastroUsuariosBean.nome}" styleClass="form-control"/>
			  	</div>
			  	<div class="form-group">
				    <label for="cpf">CPF</label>
				    <h:inputText id="cpf" value="#{cadastroUsuariosBean.cpf}" styleClass="form-control"/>
				</div>
				<div class="form-group">
				    <label for="login">Login</label>
				    <h:inputText id="login" value="#{cadastroUsuariosBean.login}" styleClass="form-control"/>
				</div>
				<div class="form-group">
				    <label for="senha">Senha</label>
				    <h:inputSecret id="senha" value="#{cadastroUsuariosBean.senha}" styleClass="form-control"/>
				</div>
			  	<h:commandButton value="Salvar" action="#{cadastroUsuariosBean.salvarUsuario}" styleClass="btn btn-default"/>
			</h:form>
		</f:view>
	</div>
</body>
</html>