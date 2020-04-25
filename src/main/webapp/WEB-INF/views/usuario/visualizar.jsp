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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/animate.css" />

</head>

<body>

	<%@ include file="../base/menu.jsp"%>

	<div class="container">

		<c:if test="${mensagemStatus != null }">
			<div class="status-message row">
				<div class="center col s4 red white-text animated bounceInLeft">
					<p>${mensagemStatus }</p>
				</div>
			</div>
		</c:if>

		<div class="row">
			<br> <br>
			<h1 class="titulo">Usuário</h1>
			<br> <br>
			<c:forEach items="usuario">
			<fmt:parseDate value="${usuario.pessoa.dtNascimento }" pattern="yyyy-MM-dd" type="date" var="parsedDate"/>

				<div class="row">


					<div class="row">
						<div class="col s6">
							<h5>ID</h5>
							<p>${usuario.idLogin }</p>
						</div>
					</div>

					<hr />

					<div class="row">
						<div class="col s6">
							<h5>Nome</h5>
							<p>${usuario.pessoa.nome }</p>
						</div>
						<div class="col s6">
							<h5>Login</h5>
							<p>${usuario.login}</p>
						</div>
					</div>	

					<hr />

					<div class="row">
						<div class="col s6">
							<h5>Email</h5>
							<p>${usuario.email}</p>
						</div>
						<div class="col s6">
							<h5>CPF</h5>
							<p class="fmt-cpf">${usuario.pessoa.cpf }</p>
						</div>
					</div>

					<hr />

					<div class="row">
						<div class="col s6">
							<h5>Data Nascimento</h5>
							<p><fmt:formatDate value="${parsedDate }" pattern="dd/MM/yyyy" /></p>
						</div>
						<div class="col s6">
							<h5>Sexo</h5>
							<p>${usuario.pessoa.sexo }</p>
						</div>
					</div>

					<hr />

					<div class="row">
						<div class="col s6">
							<h5>Telefone</h5>
							<p class="fmt-tel">${usuario.pessoa.telefone}</p>
						</div>
						<div class="col s6">
							<h5>Celular</h5>
							<p class="fmt-cel">${usuario.pessoa.celular }</p>
						</div>
					</div>

				</div>

			</c:forEach>


			<div class="row">

				<div class="col s2">
					<a href="${s:mvcUrl('listarUsuarios').build() }"
						class="btn left red">Voltar</a>
				</div>


			</div>

		</div>
	</div>




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