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
							<div class="input-field col s12">
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
								<f:input path="tel" cssClass="validate fmt-tel" />
								<f:errors path="tel" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="endereco.cep">CEP</label>
								<f:input path="endereco.cep" cssClass="validate fmt-cep" />
								<f:errors path="endereco.cep"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="endereco.logradouro">Logradouro</label>
								<f:input path="endereco.logradouro" cssClass="validate" />
								<f:errors path="endereco.logradouro" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="endereco.cidade">Cidade</label>
								<f:input path="endereco.cidade" cssClass="validate" />
								<f:errors path="endereco.cidade"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
									<f:select path="endereco.uf" cssClass="validate">
										<f:option value="" >Selecione um estado</f:option>
										<f:option value="AC">AC</f:option>
										<f:option value="AL">AL</f:option>
										<f:option value="AM">AM</f:option>
										<f:option value="AP">AP</f:option>
										<f:option value="BA">BA</f:option>
										<f:option value="CE">CE</f:option>
										<f:option value="DF">DF</f:option>
										<f:option value="ES">ES</f:option>
										<f:option value="GO">GO</f:option>
										<f:option value="MA">MA</f:option>
										<f:option value="MG">MG</f:option>
										<f:option value="MS">MS</f:option>
										<f:option value="MT">MT</f:option>
										<f:option value="PA">PA</f:option>
										<f:option value="PB">PB</f:option>
										<f:option value="PE">PE</f:option>
										<f:option value="PI">PI</f:option>
										<f:option value="PR">PR</f:option>
										<f:option value="RJ">RJ</f:option>
										<f:option value="RN">RN</f:option>
										<f:option value="RS">RS</f:option>
										<f:option value="RO">RO</f:option>
										<f:option value="RR">RR</f:option>
										<f:option value="SC">SC</f:option>
										<f:option value="SE">SE</f:option>
										<f:option value="SP">SP</f:option>
										<f:option value="TO">TO</f:option>
									</f:select>
									<label name="uf">UF</label>
									<f:errors path="endereco.uf" cssClass="helper-text red-text" />
								</div>
						</div>
						
						<div class="row">
							<div class="input-field col s6">
								<label for="endereco.bairro">Bairro</label>
								<f:input path="endereco.bairro" cssClass="validate" />
								<f:errors path="endereco.bairro"
									cssClass="left helper-text red-text" />
							</div>

							<div class="input-field col s6">
								<label for="endereco.numero">Número</label>
								<f:input path="endereco.numero" type="number" cssClass="validate" />
								<f:errors path="endereco.numero" cssClass="left helper-text red-text" />
							</div>
						</div>
						
						<div class="row">
							<div class="input-field col s12">
								<label for="endereco.complemento">Complemento</label>
								<f:input path="endereco.complemento" cssClass="validate" />
								<f:errors path="endereco.complemento" cssClass="left helper-text red-text" />
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
	<script src="/js/viacep.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 3000);
	</script>
	<!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>