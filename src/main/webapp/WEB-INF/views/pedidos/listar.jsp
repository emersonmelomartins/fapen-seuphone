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

		<c:if test="${mensagemStatus != null }">
			<div class="status-message row">
				<div class="center col s4 green white-text animated bounceInLeft">
					<p>${mensagemStatus }</p>
				</div>
			</div>
		</c:if>


		<div class="row center">
			<br> <br>
			<h1 class="titulo">Pedido de Compra</h1>
			<br> <br>

			<div class="row center">
				<f:form method="GET">
					<div class="input-field col s11">
						<input id="busca" name="busca" id="search" type="text"
							placeholder="Pesquisar por Número Pedido..." value="${busca}"
							autofocus>
					</div>
					<div class="input-field col s1">
						<button class="btn black-seuphone" type="submit">
							<i class="material-icons">search</i>
						</button>
					</div>
				</f:form>


			</div>

			<div class="input-field left">
				<a class="waves-effect waves-light btn green white-text"
					title="novo" href="${s:mvcUrl('novoPedido').build() }"><i
					class="material-icons left">add</i>adicionar</a>
			</div>

			<div class="row">
				<div class="col s12">
					<table class="responsive-table striped">
						<thead>
							<tr>
								<th>Nº</th>
								<th>Fornecedor</th>
								<th>Valor</th>
								<th>Situação</th>
								<th>Status</th>
								<th class="center-align">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPaginada.content}" var="pedido">
								<tr>
									<td>${pedido.idPedido}</td>
									<td>${pedido.fornecedor.razaoSocial}</td>
									<td><fmt:formatNumber value="${pedido.valorFinal}"
											type="currency" /></td>
									<td>${pedido.situacaoPedido.displayValue}</td>
									
									<td><c:if test="${!pedido.inativo }">
											<div class="chip green-text">Ativo</div>
										</c:if> <c:if test="${pedido.inativo }">
											<div class="chip red-text">Inativo</div>
										</c:if></td>
									<td class="center-align"><a
										class="waves-effect waves-light btn-small yellow"
										href="${s:mvcUrl('visualizarPedido').arg(0, pedido.idPedido).build() }"
										title="Visualizar"><i
											class="material-icons yellow-text text-darken-3">remove_red_eye</i></a>
										<a class="waves-effect waves-light btn-small blue"
										href="${s:mvcUrl('editarPedido').arg(0, pedido.idPedido).build() }"
										title="Editar"><i
											class="material-icons blue-text text-darken-3">edit</i></a>


										<button href="#modalExcluir"
											class="modal-excluir modal-trigger waves-effect waves-light btn-small red"
											data-descr="${pedido.idPedido }" data-tabela="pedidos"
											data-id="${pedido.idPedido }" title="Excluir">
											<i class="material-icons red-text text-darken-3">delete</i>
											<f:form
												action="${s:mvcUrl('apagarPedido').arg(0, pedido.idPedido).build() }"
												method="POST">
											</f:form>
										</button>
										<a
										class="waves-effect waves-light btn-small purple"
										href="${s:mvcUrl('gerarPdfPedido').arg(0, pedido.idPedido).build() }"
										target="_blank"
										title="Gerar PDF"><i
											class="material-icons purple-text text-darken-3">print</i></a>
										</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>



				</div>

			</div>
			<%@ include file="../base/paginacao.jsp"%>
			<%@ include file="../base/modalExcluir.jsp"%>

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
		}, 4000);
	</script>
</body>

</html>