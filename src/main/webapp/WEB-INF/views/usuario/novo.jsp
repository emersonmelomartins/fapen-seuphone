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

		<div class="row center">
			<br> <br>
			<h1 class="titulo">Usuário</h1>

			<f:form method="POST" action="${s:mvcUrl('salvarUsuario').build() }"
				modelAttribute="usuario">
				<f:hidden path="idLogin"/>
				<div class="center">

					<div class="row">

						<div class="row">
							<div class="input-field col s6">
								<label for="login">Login</label>
								<f:input path="login" cssClass="validate" />
								<f:errors path="login" cssClass="left helper-text red-text" />
							</div>
						</div>


						<div class="row">
							<div class="input-field col s6">
								<label for="senha">Senha</label>
								<f:input path="senha" type="password" cssClass="validate" />
								<f:errors path="senha"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="email">E-mail</label>
								<f:input path="email" cssClass="validate" />
								<f:errors path="email" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="pessoa.nome">Nome</label>
								<f:input path="pessoa.nome" cssClass="validate" />
								<f:errors path="pessoa.nome"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="pessoa.cpf">CPF</label>
								<f:input path="pessoa.cpf" cssClass="validate fmt-cpf" />
								<f:errors path="pessoa.cpf" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
									<label name="pessoa.dtNascimento">Data Nascimento</label>
									<f:input path="pessoa.dtNascimento" cssClass="validate datepicker" />
									<f:errors path="pessoa.dtNascimento" cssClass="helper-text red-text" />
								</div>

							<div class="input-field col s6">
									<f:select path="pessoa.sexo" id="pessoa.sexo" cssClass="validate">
										<f:option value="" >Selecione o Sexo</f:option>
										<f:option value="M">Masculino</f:option>
										<f:option value="F">Feminino</f:option>
									</f:select>
									<label name="pessoa.sexo">Sexo</label>
									<f:errors path="pessoa.sexo" cssClass="helper-text red-text" />
								</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="pessoa.telefone">Telefone</label>
								<f:input path="pessoa.telefone" cssClass="validate fmt-tel" />
								<f:errors path="pessoa.telefone"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="pessoa.celular">Celular</label>
								<f:input path="pessoa.celular" cssClass="validate fmt-cel" />
								<f:errors path="pessoa.celular" cssClass="left helper-text red-text" />
							</div>
						</div>

					</div>


					<div class="row">

						<div class="col s2">
							<a href="${s:mvcUrl('listarUsuarios').build() }"
								class="btn left red">Voltar</a>
						</div>

						<div class="col s2">
							<input type="submit" value="Salvar" class="green btn left">
						</div>

					</div>

				</div>
			</f:form>
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