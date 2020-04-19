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
			<h1 class="titulo">Produto</h1>
			<br> <br>
			<c:forEach items="produto">

				<div class="row">


					<div class="row">
						<div class="col s6">
							<h5>ID</h5>
							<p>${produto.idProduto }</p>
						</div>
					</div>
					
					<hr />
					
					<div class="row">
						<div class="col s6">
							<h5>Descrição</h5>
							<p>${produto.descricao }</p>
						</div>
					</div>
					
					<hr />
					
					<div class="row">
						<div class="col s6">
							<h5>Tipo Produto</h5>
							<p>${produto.tipoProduto }</p>
						</div>
						<div class="col s6">
							<h5>Modelo</h5>
							<p>${produto.modelo }</p>
						</div>
					</div>
					
					<hr />
					
					<div class="row">
						<div class="col s6">
							<h5>Cor</h5>
							<p>${produto.cor }</p>
						</div>
						<div class="col s6">
							<h5>Peso</h5>
							<p>${produto.peso }</p>
						</div>
					</div>
					
					<hr />
					
					<div class="row">
						<div class="col s6">
							<h5>Valor</h5>
							<p><fmt:formatNumber value="${produto.valor }"
										type="currency" /></p>
						</div>
					</div>

				</div>

			</c:forEach>


			<div class="row">

				<div class="col s2">
					<a href="${s:mvcUrl('paginaProdutos').build() }"
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