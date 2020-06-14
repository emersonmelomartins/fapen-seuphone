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
			<h1 class="titulo">Pedido de Compra</h1>
			<br> <br>

			<div class="row center">
				<f:form method="GET" modelAttribute="pedidoFiltroForm"
					id="pedidoFiltroForm">

					<f:hidden path="pagina" />
					<f:hidden path="novoFiltro" />

					<div class="input-field col s3">
						<f:select path="tipoFiltro">
							<option value="NP">Número do Pedido</option>
							<option value="ST">Situação</option>
							<option value="DT">Data Entrega</option>
							<option value="FN">Fornecedor</option>
						</f:select>
						<label>Buscar por</label>
					</div>

					<div id="filtro-np">
						<div class="input-field col s8">
							<f:input path="numeroPedido" type="number" cssClass="validate"
								placeholder="Busca por número do pedido..." />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-np" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>



					<div style="display: none;" id="filtro-st">
						<div class="input-field col s8">
							<f:select path="status">
								<f:options items="${listaStatus}" itemLabel="displayValue" />
							</f:select>
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-st" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>

					<div style="display: none;" id="filtro-dt">
						<div class="input-field col s4">
							<label class="active" for="entregaInicial">Entrega
								(Inicial)</label>
							<f:input path="entregaInicial" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s4">
							<label class="active" for="entregaFinal">Entrega (Final)</label>
							<f:input path="entregaFinal" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-dt" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>
					
					<div style="display: none;" id="filtro-fn">
						<div class="input-field col s8">
							<f:input path="fornecedor" cssClass="validate"
								placeholder="Busca por fornecedor..." />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-fn" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
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
								<th>Data Entrega</th>
								<th>Status</th>
								<th class="center-align">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPaginada.content}" var="pedido">
								<fmt:parseDate value="${pedido.dtEntrega }" pattern="yyyy-MM-dd"
									var="parsedDate" type="date" />
								<tr>
									<td>${pedido.idPedido}</td>
									<td>${pedido.fornecedor.razaoSocial}</td>
									<td><fmt:formatNumber value="${pedido.valorFinal}"
											type="currency" /></td>
									<td>${pedido.situacaoPedido.displayValue}</td>
									<td><fmt:formatDate value="${parsedDate }"
											pattern="dd/MM/yyyy" /></td>
									<td><c:if test="${!pedido.inativo }">
											<div class="chip green-text">Ativo</div>
										</c:if> <c:if test="${pedido.inativo }">
											<div class="chip red-text">Inativo</div>
										</c:if></td>
									<td class="center-align">
									
									<c:if
											test="${pedido.situacaoPedido.displayValue == 'Em Digitação' }">
											<a class="waves-effect waves-light btn-small orange"
												href="${s:mvcUrl('novoRecebimento').build() }"
												title="Novo Recebimento"><i
												class="material-icons orange-text text-darken-3">local_shipping</i></a>
										</c:if> 
										
										<c:if
											test="${pedido.situacaoPedido.displayValue == 'Recebido' }">
											<a class="waves-effect waves-light btn-small green"
												href="${s:mvcUrl('visualizarNotaFiscalPedido').arg(0, pedido.idPedido).build() }"
												title="Nota Fiscal"><i
												class="material-icons green-text text-darken-3">receipt</i></a>
										</c:if>
										
										<c:if test="">
										
										</c:if>
										
										 <a class="waves-effect waves-light btn-small yellow"
										href="${s:mvcUrl('visualizarPedido').arg(0, pedido.idPedido).build() }"
										title="Visualizar"><i
											class="material-icons yellow-text text-darken-3">remove_red_eye</i></a>
										<a class="waves-effect waves-light btn-small blue"
										href="${s:mvcUrl('editarPedido').arg(0, pedido.idPedido).build() }"
										title="Editar"><i
											class="material-icons blue-text text-darken-3">edit</i></a>


										<button href="#modalExcluir"
											class="modal-excluir modal-trigger waves-effect waves-light btn-small red"
											data-descr="estorno" data-tabela="pedidos"
											data-id="${pedido.idPedido }" title="Excluir">
											<i class="material-icons red-text text-darken-3">delete</i>
											<f:form
												action="${s:mvcUrl('estornarPedido').arg(0, pedido.idPedido).build() }"
												method="POST">
											</f:form>
										</button> <a class="waves-effect waves-light btn-small purple"
										href="${s:mvcUrl('gerarPdfPedido').arg(0, pedido.idPedido).build() }"
										target="_blank" title="Gerar PDF"><i
											class="material-icons purple-text text-darken-3">print</i></a></td>
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

	<script>
		$(document).ready(function() {

			$("#tipoFiltro").change(function() {
				var filtro = $('#tipoFiltro').val();

				if (filtro == 'NP') {
					$('#filtro-np').show();
					$('#filtro-st').hide();
					$('#filtro-dt').hide();
					$('#filtro-fn').hide();
				} else if (filtro == 'ST') {
					$('#filtro-st').show();
					$('#filtro-np').hide();
					$('#filtro-dt').hide();
					$('#filtro-fn').hide();
				} else if (filtro == 'DT') {
					$('#filtro-dt').show();
					$('#filtro-np').hide();
					$('#filtro-st').hide();
					$('#filtro-fn').hide();
				}
				 else if (filtro == 'FN') {
					 	$('#filtro-fn').show();
						$('#filtro-dt').hide();
						$('#filtro-np').hide();
						$('#filtro-st').hide();
					}
			});

			$(".paginacao").on("click", function(e) {
				e.preventDefault();
				var pagina = $(this).data("pagina");

				//Muda o valor da pagina no formulario
				$("#pagina").val(pagina);
				$("#novoFiltro").val("false");
				$("#formFiltro").submit();
			});

			$("#btn-np, #btn-st, #btn-dt, #btn-fn"/*"#filtro-np, #filtro-st, #filtro-dt"*/).on("click", function(e) {
				//if (event.which == 13 || event.keyCode == 13) {
					e.preventDefault();
					$("#novoFiltro").val("true");
					$("#pedidoFiltroForm").submit();
			    //}
				
			});
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {

		});
	</script>
</body>

</html>