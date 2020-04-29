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
		.product-image {
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
			<h1 class="titulo">Produto</h1>

			<br> <br>

			<c:forEach items="produto">

				<div class="row">

					<div class="col s3">

					</div>
					<div class="col s6">
						<div class="card">
							<br>
							<div class="card-image">
								<img class="product-image" src="/img/default_product.png" alt="Imagem do Produto">
							</div>
							<div class="card-content">
								<h5 style="text-transform: uppercase;" class="black-text">
									${produto.descricao}
								</h5>
								<hr />

								<table class="striped">
									<tbody>
										<tr>
											<td>ID:</td>
											<td>${produto.idProduto}</td>
										</tr>
										<tr>
											<td>Tipo de Produto:</td>
											<td>${produto.tipoProduto}</td>
										</tr>
										<tr>
											<td>Modelo:</td>
											<td>${produto.modelo}</td>
										</tr>
										<tr>
											<td>Cor: </td>
											<td>${produto.cor}</td>
										</tr>
										<tr>
											<td>Peso: </td>
											<td>${produto.peso}</td>
										</tr>
										<tr>
											<td>Valor: </td>
											<td><fmt:formatNumber value="${produto.valor}" type="currency" /></td>
										</tr>
										<tr>
											<td>Status:</td>
											<td>
												<c:if test="${!produto.inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if>
												<c:if test="${produto.inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if>

											</td>
										</tr>
									</tbody>
								</table>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="col s3"></div>


	</div>



	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<a href="${s:mvcUrl('listarProdutos').build() }" class="waves-effect waves-light btn red"><i class="material-icons left">arrow_back</i>Voltar</a>
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