<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link href="resourse/css/total.css" rel="stylesheet"
	type="text/css">


<title>Painel de Controle</title>
</head>
<body>

	<div class="header">
		
			<div class="logo-link"><a href="usuario-servlet?acao=homePage">cOntrol</a></div>
			<div class="cega"></div>
			<div class="user-link"> <a href="usuario-servlet?acao=editarPage">Usuário</a></div>

	</div><!--  header -->
	
	<div class="container-main">
	
		<div class="bar">
			
			<div class="centralizar">
				
				<div class="user-img">
					
					<div class="container-profile">
						<div class="profile"></div>
					</div>
					
					<div class="container-usuario">
						<h3><c:out value="${usuarioNaSessao.nome}"></c:out></h3>
					</div>
			
				</div><!-- user-img -->
			
				<a class="op" href="usuario-servlet?acao=homePage">Home</a>
				<a class="op" href="conta-servlet?acao=contasPage">Contas</a>
				<a class="op" href="usuario-servlet?acao=sairPage">Sair</a>
			
			</div><!-- centralizar -->
			
		</div><!-- bar -->
		
		<div class="content">
		
			<div class="centralizar">
				<h1>Home</h1>
				
				<center>
			
				</center>
			
			</div><!-- centralizar -->
			
		</div>
	
	</div><!-- container-main -->

</body>

</html>