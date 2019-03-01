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
		
				<h1>Editar Usuario</h1>
				
				<div class="form-usuario">
				
				<form class="form-cadastro" method ="post" action="usuario-servlet" onsubmit="return verificarCampos() true: false">
							
					<table>
							
						<tr>
							<td><input type="file" id="fotoPerfil" class="fotoPerfil" name="fotoPerfil"/></td>
						</tr>
								
						<tr>
							<td><input type="text" name="cad-id" id="cad-id" placeholder="${usuarioNaSessao.id}"></td>
						</tr>
								
						<tr>
						<td><input type="text" name="cad-nome" id="cad-nome"  placeholder="${usuarioNaSessao.nome}"></td>
						</tr>
								
						<tr>
							<td><input type="text" name=cad-login id="cad-login"  placeholder="${usuarioNaSessao.login}"></td>
						</tr>
								
						<tr>
							<td><input type="text" name="cad-senha" id="cad-senha"  placeholder="${usuarioNaSessao.senha}"></td>
						</tr>
								
						<tr>
							<td><input type="text" name="cad-email" id="cad-email"  placeholder="${usuarioNaSessao.email}"></td>
						</tr>
								
						<tr>
					
							<td><input type="submit" value="Atualizar"/></td>
						</tr>
								
					</table>
			
			   </form>
			   
			</div>	<!-- form-usuario -->
			
			</div><!-- centralizar -->
	
		</div><!-- content -->
	
	</div><!--container-main  -->

	<script type="text/javascript">
	
		function valorDigitado() {
			var pesquisar = document.getElementById("pesquisar").value;
			alert(pesquisar);
		}
	
		function verificarCampos() {

			if (document.getElementById("nome").value == "") {
				alert("insira uma descrição");
				return false;

			} else if (document.getElementById("login").value == "") {
				alert("insira uma link");
				return false;
				
			}else if (document.getElementById("senha").value == "") {
				alert("insira uma link");
				return false;
			}

			return true;

		}
			
	</script>

</body>

</html>