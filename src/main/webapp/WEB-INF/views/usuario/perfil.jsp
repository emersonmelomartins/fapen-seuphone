<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Seuphone - Última geração em suas mãos.</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/animate.css" />

<style>
	/*Configuração Temporária*/
	.profile-avatar {
		max-width: 150px;
		margin: 0 auto;
	}
</style>
</head>

<body>

	<%@ include file="../base/menu.jsp"%>

<div class="container">

	<div class="row">
		<br> <br>
		<h1 class="titulo">Usuário</h1>

		<br> <br>

		


			<div class="row">

				<div class="col s3">

				</div>
				<div class="col s6">
					<div class="card">
						<br>
						<div class="card-image">
						
						
						<c:forEach items="perfil">
							<c:if test="${perfil.getCaminhoFoto() == null }">
								<img class="profile-avatar" src="/img/default_avatar.png" alt="Avatar do Usuário">
							</c:if>
							<c:if test="${perfil.getCaminhoFoto() != null}">
								<img class="profile-avatar" src="/${perfil.getCaminhoFoto() }" alt="Avatar do Usuário">
							</c:if>
						</c:forEach>
							<f:form action="${s:mvcUrl('alterarFotoPerfil').build() }" method="POST" enctype="multipart/form-data">
								<div class="file-field input-field">
									<div class="btn indigo">
										<span><i class="material-icons">attach_file</i></span>
										<input type="file" name="foto" multiple>
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text" placeholder="Selecione uma imagem">
									</div>
									<button class="btn-small indigo"type="submit">Alterar Foto</button>
								</div>
							</f:form>
						</div>
						<div class="card-content">
							<h5 style="text-transform: uppercase;" class="black-text">

							</h5>
							<hr />

							<f:form method="POST" action="#" modelAttribute="perfil"
								class="col s12">
							<table class="striped">
									<f:hidden path="idLogin" />
								<tbody>
									<tr>
										<td>Login:</td>
										<td><f:input path="login" cssClass="validate"/>
											<f:errors path="login" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><f:input path="email" cssClass="validate" />
											<f:errors path="email" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>CPF:</td>
										<td><f:input path="pessoa.cpf" cssClass="validate fmt-cpf"/>
											<f:errors path="pessoa.cpf" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>Data Nascimento: </td>
										<td>
											<f:input path="pessoa.dtNascimento" cssClass="validate datepicker" placeholder="01/02/1990" />
											<f:errors path="pessoa.dtNascimento" cssClass="helper-text red-text" />
										</td>
									</tr>
									<tr>
										<td>Sexo: </td>
										<td><f:select path="pessoa.sexo" id="pessoa.sexo" cssClass="validate">
											<f:option value="">Selecione o Sexo</f:option>
											<f:option value="M">Masculino</f:option>
											<f:option value="F">Feminino</f:option>
										</f:select>
										<f:errors path="pessoa.sexo" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>Telefone: </td>
										<td><f:input path="pessoa.telefone" cssClass="validate fmt-tel"/>
											<f:errors path="pessoa.telefone" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>Celular: </td>
										<td><f:input path="pessoa.celular" cssClass="validate fmt-cel"/>
											<f:errors path="pessoa.celular" cssClass="helper-text red-text" /></td>
									</tr>
									<tr>
										<td>Status:</td>
										<td>
											<c:if test="${!inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if>
												<c:if test="${inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if>
										</td>
									</tr>
								</tbody>
							</table>
						</f:form>

							<h5>Permissões</h5>
							<c:forEach items="${perfil.authorities }" var="authority">
								<div class="chip">${authority.getAuthority() }</div>
							</c:forEach>

	</div>
</div>

</div>
<div class="col s3"></div>


</div>



<div class="row">
	<div class="col s3"></div>
	<div class="col s6">
		<a href="${s:mvcUrl('listarUsuarios').build() }" class="waves-effect waves-light btn red"><i class="material-icons left">arrow_back</i>Voltar</a>
	</div>
	<div class="col s3"></div>
</div>
</div>
</div>

<%@ include file="../base/rodape.jsp"%>

	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 3000);
	</script>
	<!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>
