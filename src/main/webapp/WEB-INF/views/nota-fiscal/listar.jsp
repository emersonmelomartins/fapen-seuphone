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
			<h1 class="titulo">Notas Fiscais</h1>
			<br> <br>

			<div class="row center">
				<f:form method="GET" modelAttribute="notaFiltroForm"
					id="notaFiltroForm">
					
					<f:hidden path="pagina" />
					<f:hidden path="novoFiltro" />
					
					<div class="input-field col s3">
						<f:select path="tipoFiltro">
							<option value="NF">Numero NF</option>
							<option value="DTNF">Data NF</option>
							<option value="DTRE">Data Recebimento</option>
							<option value="NP">Numero Pedido</option>
						</f:select>
						<label>Buscar por</label>
					</div>

					<div id="filtro-nf">
						<div class="input-field col s8">
							<f:input path="numeroNota" type="number" cssClass="validate"
								placeholder="Busca por número da nota fiscal..." />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-nf" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>
					
					<div style="display: none;" id="filtro-dtnf">
						<div class="input-field col s4">
							<label class="active" for="dataNfInicial">Data NF
								(Inicial)</label>
							<f:input path="dataNfInicial" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s4">
							<label class="active" for="dataNfFinal">Data NF (Final)</label>
							<f:input path="dataNfFinal" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-dtnf" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>
					
					<div style="display: none;" id="filtro-dtre">
						<div class="input-field col s4">
							<label class="active" for="dataRecebInicial">Data Recebimento
								(Inicial)</label>
							<f:input path="dataRecebInicial" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s4">
							<label class="active" for="dataRecebFinal">Data Recebimento (Final)</label>
							<f:input path="dataRecebFinal" cssClass="validate datepicker" />
						</div>
						<div class="input-field col s1">
							<button class="btn black-seuphone" id="btn-dtre" type="button">
								<i class="material-icons">search</i>
							</button>
						</div>
					</div>
					
					<div style="display: none;" id="filtro-np">
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

				</f:form>


			</div>

			<div class="input-field left">
				<a class="waves-effect waves-light btn green white-text"
					title="novo" href="${s:mvcUrl('novoRecebimento').build() }"><i class="material-icons left">add</i>Novo Recebimento</a>
			</div>

			<div class="row">
				<div class="col s12">
					<table class="responsive-table striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Número Pedido</th>
								<th>Série NF</th>
								<th>Número NF</th>
								<th>Data NF</th>
								<th>Data Recebimento</th>
								<th class="center-align">Ação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPaginada.content}" var="notaFiscal">
								<fmt:parseDate value="${notaFiscal.dtNotaFiscal }"
									pattern="yyyy-MM-dd" var="parsedDateNotaFiscal" type="date" />
								<fmt:parseDate value="${notaFiscal.dtRecebimento }"
									pattern="yyyy-MM-dd" var="parsedDateRecebimento" type="date" />
								<tr>
									<td>${notaFiscal.idNotaFiscal}</td>
									<td>${notaFiscal.pedido.idPedido}</td>
									<td>${notaFiscal.serieNotaFiscal}</td>
									<td>${notaFiscal.numeroNotaFiscal}</td>
									<td><fmt:formatDate value="${parsedDateNotaFiscal }"
										pattern="dd/MM/yyyy" /></td>
										<td><fmt:formatDate value="${parsedDateRecebimento }"
										pattern="dd/MM/yyyy" /></td>
									<td class="center-align"><a
										class="waves-effect waves-light btn-small yellow" href="${s:mvcUrl('visualizarNotaFiscal').arg(0, notaFiscal.idNotaFiscal).build() }"
										title="Visualizar"><i
											class="material-icons yellow-text text-darken-3">remove_red_eye</i></a>
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
		$(document).ready(function() {

			$("#tipoFiltro").change(function() {
				var filtro = $('#tipoFiltro').val();

				console.log(filtro);
				if (filtro == 'NF') {
					$('#filtro-nf').show();
					$('#filtro-dtnf').hide();
					$('#filtro-dtre').hide();
					$('#filtro-np').hide();
				} else if (filtro == 'DTNF') {
					$('#filtro-dtnf').show();
					$('#filtro-nf').hide();
					$('#filtro-dtre').hide();
					$('#filtro-np').hide();
				} else if (filtro == 'DTRE') {
					$('#filtro-dtre').show();
					$('#filtro-nf').hide();
					$('#filtro-dtnf').hide();
					$('#filtro-np').hide();
				} else if (filtro == 'NP') {
					$('#filtro-np').show();
					$('#filtro-dtre').hide();
					$('#filtro-nf').hide();
					$('#filtro-dtnf').hide();
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

			$("#btn-nf, #btn-dtnf, #btn-dtre, #btn-np").on("click", function(e) {
					e.preventDefault();
					$("#novoFiltro").val("true");
					$("#notaFiltroForm").submit();
				
			});
		});
	</script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 4000);
	</script>
	
	
</body>

</html>