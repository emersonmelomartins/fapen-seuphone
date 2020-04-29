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
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection" />

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
			<h1 class="titulo">Fornecedores</h1>
			<br> <br>

			<div class="row center">
				<f:form method="GET">
					<div class="input-field col s11">
						<input id="busca" name="busca" id="search" type="text" placeholder="Pesquisar por Razão Social..."
							value="${busca}" autofocus>
					</div>
					<div class="input-field col s1">
						<button class="btn black-seuphone" type="submit">
							<i class="material-icons">search</i>
						</button>
					</div>
				</f:form>

				
			</div>
			
			<div class="input-field left">
				<a class="waves-effect waves-light btn green white-text" title="novo"
				href="${s:mvcUrl('novoFornecedor').build() }"><i class="material-icons left">add</i>adicionar</a>
			</div>

			<div class="row">
				<div class="col s12">		
					<table class="responsive-table striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Razão Social</th>
								<th>CNPJ</th>
								<th>Telefone</th>
								<th>Status</th>
								<th class="center-align">Ação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPaginada.content}" var="fornecedor">
								<tr>
									<td>${fornecedor.id}</td>
									<td>${fornecedor.razaoSocial}</td>
									<td class="fmt-cnpj">${fornecedor.cnpj}</td>
									<td class="fmt-tel">${fornecedor.tel}</td>
									<td>
										<c:if test="${!fornecedor.inativo }">
											<div class="chip green-text">Ativo</div>
										</c:if>
										<c:if test="${fornecedor.inativo }">
											<div class="chip red-text">Inativo</div>
										</c:if>
									</td>
				<td class="center-align"><a class="waves-effect waves-light btn-small yellow"
						href="${s:mvcUrl('visualizarFornecedor').arg(0, fornecedor.id).build() }" title="Visualizar"><i
							class="material-icons yellow-text text-darken-3">remove_red_eye</i></a> <a
						class="waves-effect waves-light btn-small blue"
						href="${s:mvcUrl('editarFornecedor').arg(0, fornecedor.id).build() }" title="Editar"><i
							class="material-icons blue-text text-darken-3">edit</i></a>


					<button href="#modalExcluir" class="modal-excluir modal-trigger waves-effect waves-light btn-small red"
						data-descr="${fornecedor.razaoSocial }" data-tabela="fornecedores" data-id="${fornecedor.id }" title="Excluir">
						<i class="material-icons red-text text-darken-3">delete</i>
						<f:form action="${s:mvcUrl('apagarFornecedor').arg(0, fornecedor.id).build() }" method="POST">
						</f:form>
					</button></td>
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
		setTimeout(function () {
			$('.status-message').fadeOut('slow');
		}, 4000);
	</script>
</body>

</html>