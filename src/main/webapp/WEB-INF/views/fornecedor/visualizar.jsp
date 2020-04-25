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
			<h1 class="titulo">Fornecedor</h1>
			<br> <br>
			<c:forEach items="fornecedor">


				<div class="row">

					<h5>Dados Cadastrais</h5>
					<hr />

					<div class="row">
						<div class="col s6">
							<h6>ID</h6>
							<p>
								<b>${fornecedor.id }</b>
							</p>
						</div>
					</div>



					<div class="row">
						<div class="col s6">
							<h6>Razão Social</h6>
							<p>
								<b>${fornecedor.razaoSocial}</b>
							</p>
						</div>
						
						<div class="col s6">
							<h6>Telefone</h6>
							<p style="font-weight: bold;" class="fmt-tel">
								${fornecedor.tel}
							</p>
						</div>

					</div>


					<div class="row">
						<div class="col s6">
							<h6>CNPJ</h6>
							<p style="font-weight: bold;" class="fmt-cnpj">${fornecedor.cnpj}</p>
						</div>
						
						<div class="col s6">
							<h6>E-mail</h6>
							<p style="font-weight: bold;">${fornecedor.email}</p>
						</div>



					</div>


					<h5>Endereço</h5>
					<hr />



					<div class="row">
						<div class="col s6">
							<h6>CEP</h6>
							<p>
								<b><span class="fmt-cep">${fornecedor.endereco.cep}</span></b>
							</p>
						</div>
					</div>

					<div class="row">
						<div class="col s12">
							<h6>Logradouro</h6>
							<p>
								<b>${fornecedor.endereco.logradouro}</b>
							</p>
						</div>
					</div>

					<div class="row">

						<div class="col s6">
							<h6>Bairro</h6>
							<p>
								<b>${fornecedor.endereco.bairro}</b>
							</p>
						</div>
						<div class="col s6">
							<h6>Número</h6>
							<p>
								<b>${fornecedor.endereco.numero}</b>
							</p>
						</div>
					</div>

					<div class="row">

						<div class="col s6">
							<h6>UF</h6>
							<p>
								<b>${fornecedor.endereco.uf}</b>
							</p>
						</div>
						<div class="col s6">
							<h6>Município</h6>
							<p>
								<b>${fornecedor.endereco.cidade}</b>
							</p>
						</div>
					</div>

					<div class="row">
						<div class="col s6">
							<h6>Complemento</h6>
							<p>
								<b>${fornecedor.endereco.complemento}</b>
							</p>
						</div>
					</div>




					<hr />


				</div>

			</c:forEach>


			<div class="row">

				<div class="col s2">
					<a href="${s:mvcUrl('listarFornecedores').build() }"
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
