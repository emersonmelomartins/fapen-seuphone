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
		<f:form action="${s:mvcUrl('salvarRecebimento').build() }"
			method="post" modelAttribute="recebimentoForm">

			<f:hidden path="idRecebimento" />

			<div class="row">
				<div class="col s12">

					<div class="card">
						<div class="card-content">
							<span class="card-title center-align titulo">Recebimento</span>

							<div class="row">
								<div class="input-field col s3">
									<f:input path="serieNotaFiscal" type="number"
										cssClass="validator" />
									<label for="serieNotaFiscal">Série NF</label>
									<f:errors path="serieNotaFiscal"
										cssClass="helper-text red-text" />
								</div>
								<div class="input-field col s3">
									<f:input path="numeroNotaFiscal" type="number"
										cssClass="validator" />
									<label for="numeroNotaFiscal">Número NF</label>
									<f:errors path="numeroNotaFiscal"
										cssClass="helper-text red-text" />
								</div>
								<div class="input-field col s3">
									<f:input path="dtNotaFiscal" cssClass="datepicker validator" />
									<label for="dtNotaFiscal">Data NF</label>
									<f:errors path="dtNotaFiscal" cssClass="helper-text red-text" />
								</div>
								<div class="input-field col s3">
									<f:input path="dtRecebimento" cssClass="datepicker validator" />
									<label for="dtRecebimento">Data Recebimento</label>
									<f:errors path="dtRecebimento" cssClass="helper-text red-text" />
								</div>

							</div>
							<div class="row">
								<div class="input-field col s12">
									<f:select path="pedido" cssClass="validate">
										<f:option value="">Selecione</f:option>
										<f:options items="${listaPedidos}" itemLabel="infoPedido" />
									</f:select>
									<label for="pedido">Pedido de Compra</label>
									<f:errors path="pedido" cssClass="helper-text red-text" />
								</div>
							</div>


							<span class="card-title center-align titulo center"><p>Descrição
									do Pedido</p></span>
							<!-- descrição pedido vai aqui -->

							<div class="row">
								<div class="col s12">
									<div id="dadosTabela">
										<table class="responsive-table striped">
											<thead>
												<tr>
													<th>Verificado</th>
													<th>Produto</th>
													<th>Quantidade</th>
													<th>Valor Unitário</th>
													<th>Valor Total</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${recebimentoForm.itens }" var="itemReceb"
													varStatus="status">
													<tr>
														
														<f:hidden path="itens[${status.index }].quantidade" />
														<f:hidden path="itens[${status.index }].produto" />
														<f:hidden path="itens[${status.index }].precoUnitario" />
														<f:hidden path="itens[${status.index }].valorTotal" />
														<td>
															<p>
																<label> <input type="checkbox"
																	name="itens[${status.index }].verificado"
																	id="itens[${status.index }].verificado"
																	class="filled-in" /> <span>OK</span>
																</label>

															</p> <f:errors path="itens[${status.index }].verificado"
																cssClass="helper-text red-text" />
														</td>
														<td>${itemReceb.produto.descricao }</td>
														<td>${itemReceb.quantidade }</td>
														<td>${itemReceb.precoUnitario }</td>
														<td>${itemReceb.valorTotal }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>


						</div>
						<div class="card-action">
							<div class="row">
								<div class="col s2">
									<a href="${s:mvcUrl('listarPedidos').build() }" class="waves-effect waves-light btn red"><i
										class="material-icons left">arrow_back</i>Voltar</a>
								</div>

								<div class="col s2">
									<button type="submit"
										class="waves-effect waves-light btn green white-text">
										<i class="material-icons left">add</i>Salvar
									</button>
								</div>
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
	<script>
		function atualizaTabela(dados) {
			var cHtml = $(dados).find("#dadosRegistro").html();
			console.log(cHtml);
			$("#dadosTabela").html(cHtml);
			$("select").formSelect();
		}

		function erroAjax(err) {
			console.log("Ocorreu um erro --> " + err);
		}

		$("body").on("change", "#pedido", function(event) {
			$.ajax({
				type : "POST",
				data : $("form").serialize(),
				url : "${s:mvcUrl('carregaItensRecebimento').build()}",
				success : atualizaTabela,
				error : erroAjax
			});
			console.log(atualizaTabela);
		});
	</script>
</body>

</html>