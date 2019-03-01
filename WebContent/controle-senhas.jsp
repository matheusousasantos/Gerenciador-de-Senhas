<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link href="resourse/css/total.css" rel="stylesheet" type="text/css">


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
			
					<h1>Controle de Senhas</h1>
						
						<div class="form-senha">
						
							<div class="centralizar">
							
								
								<form class="form-cadastro"  id="form-cadastro" action="conta-servlet" method="post">
									
									<table>
									
										<tr>				
											<td style="display:none;"><input type="text" id="id" name="id" value="${conta.id}"></td>
										</tr>
										
										<tr>			
											<td><input type="text" id="descricao" name="descricao" placeholder="Descrição" value="${conta.descricao}" required></td>
											<td><input type="text" id="link" name="link" placeholder="Link" value="${conta.link}" ></td>
										</tr>
										
										<tr>			
											<td><input type="text" id="login" name="login" placeholder="login" value="${conta.login}" required></td>
											<td><input type="text" id="senha" name="senha" placeholder="Senha" value="${conta.senha}" required></td>
										</tr>
										
										<tr>			
											<td><select id="tipo" class="tipo">
												<option>Emprego</option>
												<option>Estudo</option>
												<option>Rede Social</option>
												<option>Outros</option>
											</select></td>
											
											<td><input type="text" id="imagem" name="imagem" placeholder="#Imagem" value="${conta.imagem}" required></td>
											
										</tr>
										
										<tr>			
						
											<td><input type="submit" value="Cancelar" onclick="document.getElementById('form-cadastro').action = 'conta-servlet?acao=resetPage'"></td>
											<td><input type="submit" value="Enviar"></td>
											
										</tr>
									
									</table>
								
								</form><!-- form-cadastro -->
								
							</div><!-- centralizar -->
							
						</div><!-- form-senha -->
						
						<br>
						
						<div class="container-box">
						
							<div class="centralizar">
							
								<center>Contas</center>
								
								<form action="conta-servlet?acao=pesquisarGrupoConta">
								
									<div class="filtro">
									
										<h3>Buscar por: </h3>
										<select id="tipo" class="tipo">
											<option>Emprego</option>
											<option>Estudo</option>
											<option>Rede Social</option>
											<option>Outros</option>
											
										</select>
																	
										<input type="submit" value="Buscar">
										
									</div><!-- filtro -->
								
								</form>
								
								<ul class="lista-box">
				
								<c:forEach var="conta" items="${contas}">
								
								<li class="linha-box">
										
									<div class="box-contas">
										
										<div class="box-opcoes">
											<a href="conta-servlet?acao=editarConta&id=${conta.id}">E</a>
											<a href="conta-servlet?acao=excluirConta&id=${conta.id}">X</a>
										</div><!-- box-opcoes -->
										
										<div>
											<a href="${conta.link}" target="_blank">
											<div class="logo" style="background-image: url(${conta.imagem});"></div>
											</a>
												
										</div>
										
										<div class="box-descricao"><c:out value="${conta.descricao}"></c:out></div>
											
									</div><!-- box-contas -->
					
								 </li>
								 	
							</c:forEach>
								
							</ul>
						</div><!-- centralizar -->
			
					</div><!-- container-box -->
		
				</div><!-- centralizar -->
		
			</div><!-- content -->
		
		</div><!-- container-main -->
		
</body>

<script type="text/javascript">
	function valorDigitado() {
		var pesquisar = document.getElementById("pesquisar").value;
		alert(pesquisar);
	}

	function verificarCampos() {

		if (document.getElementById("descricao").value == "") {
			alert("insira uma descrição");
			return false;

		} else if (document.getElementById("link").value == "") {
			alert("insira uma link");
			return false;
			
		}else if (document.getElementById("login").value == "") {
			alert("insira uma link");
			return false;
			
		}else if (document.getElementById("senha").value == "") {
			alert("insira uma link");
			return false;
		}else if (document.getElementById("imagem").value == "") {
			alert("insira uma link");
			return false;
		}
		

		return true;

	}
	
	function buscar(){
		
		var filtro = document.getElementById('filtro').value;
		alert(filtro);
		
	}
	
</script>

</html>