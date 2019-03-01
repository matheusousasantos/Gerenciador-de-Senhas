<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width-device-width, initial-scale=1.0, maximum-scale=1.0"/>

<title>cOntrol</title>

<link href="resourse/css/total.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>

	<div class="login-container">

		<div class="form">
		
			<form class="form-cadastro" method ="post" action="usuario-registro-servlet" onsubmit="return validarCamposRegistro()? true : false;">
				
				<div class="titulo"><h2>Cadastro</h2></div>
				
				<table>
					<tr>
						<td><input type="text" name="cad-nome" id="cad-nome" placeholder="Nome" required></td>
					</tr>
					
					<tr>
						<td><input type="text" name="cad-login" id="cad-login" placeholder="Login" required></td>
					</tr>
					
					<tr>
						<td><input type="text" name="cad-senha" id="cad-senha" placeholder="Senha" required></td>
					</tr>
					
					<tr>
						<td><input type="text" name="cad-email" id="cad-email" placeholder="E-mail" required></td>
					</tr>
					
					<tr>
					
						<td><input type="submit" value="Cadastrar"/></td>
					</tr>
					
				</table>

				<p class="mensagem">
					Você tem um registro? <a href="#">Login</a></p>

			</form>

			<form class="form-login" method ="post" action="usuario-login-servlet" onsubmit="return validarCamposLogin()? true : false;">
				
				<div class="titulo"><h2>Login</h2></div>
				
				<table>
					
					<tr>
						<td><input type="text" name="log-login" id="log-login" placeholder="Login" required></td>
					</tr>
	
					<tr>
						<td><input type="text" name="log-senha" id="log-senha" placeholder="Senha" required></td>
					</tr>
	
					<tr>
						<td><input type="submit" value="Logar"/></td>
					</tr>
				
				</table>
				
				<p class="mensagem">Você tem um registro?<a href="#">Criar Conta</a></p>
				
			</form>

			<h2><c:out value="${msg}"></c:out></h2>

		</div>
	</div>

	<script type="text/javascript">
		
		
		function validarCamposLogin() {
			
			if(document.getElementById("log-login").value == ""){
				alert('Insira o login!');
				return false;
			}
			
			else if(document.getElementById("log-senha").value == ""){
				alert('Insira a senha!');
				return false;
			}
			
			return true;	
		}
		
		
		function validarCamposRegistro() {
			
			if(document.getElementById("cad-nome").value == ""){
				alert('Insira seu nome!');
				return false;
			}
			
			else if(document.getElementById("cad-login").value == ""){
				alert('Insira a login!');
				return false;
			}
			
			else if(document.getElementById("cad-senha").value == ""){
				alert('Insira a senha!');
				return false;
			}
			
			else if(document.getElementById("cad-email").value == ""){
				alert('Insira o email!');
				return false;
			}
			
			return true;	
		}
		
		$('.mensagem a').click(function(){
			
			   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
			});		
		
	</script>

</body>

</html>