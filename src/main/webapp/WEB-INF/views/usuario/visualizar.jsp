<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Seuphone - Última geração em suas mãos.</title>

	<!-- Materialize CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection" />

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

			<c:forEach items="usuario">
				<fmt:parseDate value="${usuario.pessoa.dtNascimento }" pattern="yyyy-MM-dd" type="date" var="parsedDate" />

				<div class="row">

					<div class="col s3">

					</div>
					<div class="col s6">
						<div class="card">
							<br>
							<div class="card-image">
								<img class="profile-avatar" src="/img/default_avatar.png" alt="Avatar do Usuário">
							</div>
							<div class="card-content">
								<h5 style="text-transform: uppercase;" class="black-text">
									${usuario.pessoa.nome }
								</h5>
								<hr />

								<table class="striped">
									<tbody>
										<tr>
											<td>ID:</td>
											<td>${usuario.idLogin}</td>
										</tr>
										<tr>
											<td>Login:</td>
											<td>${usuario.login}</td>
										</tr>
										<tr>
											<td>Email:</td>
											<td>${usuario.email}</td>
										</tr>
										<tr>
											<td>CPF:</td>
											<td class="fmt-cpf">${usuario.pessoa.cpf}</td>
										</tr>
										<tr>
											<td>Data Nascimento: </td>
											<td>
												<fmt:formatDate value="${parsedDate }" pattern="dd/MM/yyyy" />
											</td>
										</tr>
										<tr>
											<td>Sexo: </td>
											<td>${usuario.pessoa.sexo}</td>
										</tr>
										<tr>
											<td>Telefone: </td>
											<td class="fmt-tel">${usuario.pessoa.telefone}</td>
										</tr>
										<tr>
											<td>Status:</td>
											<td>
												<c:if test="${!usuario.inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if>
												<c:if test="${usuario.inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if>

											</td>
										</tr>
									</tbody>
								</table>

								<h5>Permissões</h5>
								<div class="chip blue">ROLE_ADMIN</div>
								<div class="chip red">ROLE_GERENTE</div>
								<div class="chip green">ROLE_VENDEDOR</div>
								<div class="chip deep-purple">ROLE_ESTOQUE</div>
								<div class="chip teal">ROLE_NOTAFISCAL</div>
								<div class="chip yellow">ROLE_USUARIO</div>
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

	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
</body>

</html>