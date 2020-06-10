<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<style>
/*Configuração Temporária*/
.helper-text {
	font-family: Arial, sans-serif;
	text-align: left;
}

.product-image {
	max-width: 150px;
	margin: 0 auto;
}
</style>

</head>

<body>

	<%@ include file="../base/menu.jsp"%>

	<div class="container">
		<br>
		<f:form action="${s:mvcUrl('salvarPedido').build()}" method="post"
			modelAttribute="pedidoCompraForm">

			<f:hidden path="pedidoCompra.idPedido" />

			<div class="row">
				<div class="col s12">

					<div class="card">
						<div class="card-content">
							<span class="card-title center-align titulo">Dados do
								Pedido - Nº: ${pedidoCompraForm.pedidoCompra.idPedido}</span>

							<div class="row">
								<div class="input-field col s3">
									<f:select path="pedidoCompra.situacaoPedido"
										cssClass="validate">
										<f:option value="">Selecione</f:option>
										<f:options items="${listaStatusPedido}"
											itemLabel="displayValue" />
									</f:select>
									<label for="pedidoCompra.situacaoPedido">Situação
										Pedido</label>
									<f:errors path="pedidoCompra.situacaoPedido"
										cssClass="helper-text red-text" />
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<f:select path="pedidoCompra.fornecedor" cssClass="validate">
										<f:option value="">Selecione</f:option>
										<f:options items="${listaFornecedores}" itemValue="id"
											itemLabel="razaoSocial" />
									</f:select>
									<label for="pedidoCompra.fornecedor">Fornecedor</label>
									<f:errors path="pedidoCompra.fornecedor"
										cssClass="helper-text red-text" />
								</div>
							</div>
							<div class="row">
								<div class="input-field col s3">
									<f:input path="pedidoCompra.dtEntrega"
										cssClass="validate datepicker" />
									<label for="pedidoCompra.dtEntrega">Entrega</label>
									<f:errors path="pedidoCompra.dtEntrega"
										cssClass="helper-text red-text" />
								</div>
								<div class="input-field col s9">
									<f:select path="pedidoCompra.condicaoPagamento"
										cssClass="validate">
										<f:option value="">Selecione</f:option>
										<f:options items="${listaCondicaoPagto}"
											itemLabel="displayValue" />
									</f:select>
									<label for="pedidoCompra.condicaoPagamento">Condição de
										Pagamento</label>
									<f:errors path="pedidoCompra.condicaoPagamento"
										cssClass="helper-text red-text" />
								</div>
							</div>

							<span class="card-title center-align titulo center"><p>Descrição
									do Pedido</p>
								<button id="btnNovoItem" type="button"
									class="waves-effect waves-light btn-small green white-text right"
									title="Novo Item">
									<i class="material-icons left">add</i> Novo Item
								</button> </span>
							<div class="row">
								<div class="col s12">
									<f:errors path="itensPedidoCompra" cssClass="red-text" />
									<div id="dadosItens">
										<c:forEach items="${pedidoCompraForm.itensPedidoCompra}"
											var="itemPedido" varStatus="status">

											<div class="card">
												<div class="card-content">
													<f:hidden
														path="itensPedidoCompra[${status.index}].idDescricao" />
													<f:hidden path="itensPedidoCompra[${status.index}].pedido" />
													<div class="row">
														<div class="input-field col s4">
															<f:select
																path="itensPedidoCompra[${status.index}].produto"
																cssClass="validate">
																<f:option value="">Selecione</f:option>
																<f:options items="${listaProdutos}"
																	itemValue="idProduto" itemLabel="descricao" />
															</f:select>
															<label class="active"
																for="itensPedidoCompra[${status.index}].produto">Produto</label>
															<f:errors
																path="itensPedidoCompra[${status.index}].produto"
																cssClass="helper-text red-text" />
														</div>

														<div class="input-field col s3">
															<f:input type="number"
																path="itensPedidoCompra[${status.index}].quantidade"
																cssClass="validate" />
															<label class="active"
																for="itensPedidoCompra[${status.index}].quantidade">Quantidade</label>
															<f:errors
																path="itensPedidoCompra[${status.index}].quantidade"
																cssClass="helper-text red-text" />
														</div>

														<div class="input-field col s3">
															<f:input readonly="true" type="number"
																path="itensPedidoCompra[${status.index}].valor"
																cssClass="validate" />
															<label class="active"
																for="itensPedidoCompra[${status.index}].valor">Valor
																Unitário</label>
															<f:errors path="itensPedidoCompra[${status.index}].valor"
																cssClass="helper-text red-text" />
														</div>

														<div class="input-field col s2">
															<button class="btn-small red deletaItem" title="excluir"
																type="button" value="${status.index}">
																<i class="material-icons">delete</i>
															</button>
														</div>
													</div>
												</div>
											</div>

										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="card-action">
							<div class="row">

								<a href="${s:mvcUrl('listarPedidos').build() }"
									class="waves-effect waves-light btn red"><i
									class="material-icons left">arrow_back</i>Voltar</a>



								<button type="submit"
									class="waves-effect waves-light btn green white-text">
									<i class="material-icons left">add</i>Salvar
								</button>

							</div>
						</div>
					</div>

				</div>
			</div>

		</f:form>
	</div>
	<%@ include file="../base/rodape.jsp"%>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/addOrderItem.js"></script>
</body>

</html>