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
			<h1 class="titulo">Fornecedor</h1>

			<f:form method="POST" action="${s:mvcUrl('salvarFornecedor').build() }"
				modelAttribute="fornecedor">
				<f:hidden path="id"/>
				<div class="center">

					<div class="row">

						<div class="row">
							<div class="input-field col s6">
								<label for="razaoSocial">Razao Social</label>
								<f:input path="razaoSocial" cssClass="validate" />
								<f:errors path="razaoSocial" cssClass="left helper-text red-text" />
							</div>
						</div>


						<div class="row">
							<div class="input-field col s6">
								<label for="cnpj">CNPJ</label>
								<f:input path="cnpj" cssClass="validate fmt-cnpj" />
								<f:errors path="cnpj"
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
								<label for="categoriaProduto">Categoria Produto</label>
								<f:input path="categoriaProduto" cssClass="validate" />
								<f:errors path="categoriaProduto"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="tel">Telefone</label>
								<f:input path="tel" cssClass="validate" />
								<f:errors path="tel" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="endereco.cep">CEP</label>
								<f:input path="endereco.cep" cssClass="validate" />
								<f:errors path="endereco.cep"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="endereco.logradouro">Logradouro</label>
								<f:input path="endereco.logradouro" cssClass="validate" />
								<f:errors path="endereco.logradouro" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						
						

					</div>


					<div class="row">

						<div class="col s2">
							<a href="${s:mvcUrl('listarFornecedores').build() }"
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