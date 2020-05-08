<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="pt-BR">

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

		<c:if test="${mensagemSucesso != null }">
			<div class="status-message row">
				<div class="center col s4 green white-text animated bounceInLeft">
					<p>${mensagemSucesso }</p>
				</div>
			</div>
		</c:if>
		<c:if test="${mensagemErro != null }">
			<div class="status-message row">
				<div class="center col s4 red white-text animated bounceInLeft">
					<p>${mensagemErro }</p>
				</div>
			</div>
		</c:if>


		<div class="row center">
			<br> <br>
			<h1 class="titulo">Nova Senha</h1>
			<br> <br>

			<div class="row">
				<f:form method="POST" action="${s:mvcUrl('trocarSenha').build() }"
					modelAttribute="recuperarSenhaForm">
					<f:hidden path="usuario.idLogin" />

					<div class="row">
						<div class="col s4"></div>
						<div class="col s4">

							<div class="input-field col s12">
								<label name="novoPassword">Nova Senha</label>
								<f:input path="novoPassword" type="password" cssClass="validate" />
								<f:errors path="novoPassword" cssClass="helper-text red-text" />
							</div>
							<div class="input-field col s12">
								<label for="confirmarPassword">Confirmar Senha</label>
								<f:input path="confirmarPassword" type="password"
									cssClass="validate" />
								<f:errors path="confirmarPassword"
									cssClass="helper-text red-text" />
							</div>


							<div class="input-field col s12">
								<input type="submit" value="Enviar" class="left btn botao">
							</div>

						</div>
					</div>
				</f:form>
			</div>

		</div>
	</div>
	<%@ include file="../base/rodape.jsp"%>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/modalExcluir.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 5000);
	</script>
</body>

</html>