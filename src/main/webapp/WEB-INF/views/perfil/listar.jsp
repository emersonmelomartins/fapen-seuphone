
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
			<h1 class="titulo">Perfis</h1>
			<br> <br>

			<div class="row center">
				<f:form method="GET">
					<div class="input-field col s8">
						<input id="busca" name="busca" id="search" type="text"
							placeholder="Pesquisar por Role" value="${busca}">
					</div>
					<div class="input-field col s1">
						<button class="btn-small black-seuphone" type="submit">
							<i class="material-icons">search</i>
						</button>
					</div>
				</f:form>

				<div class="input-field col s2 left">
					<a
						class="btn-floating btn-large waves-effect waves-light green right"
						title="novo" href="${s:mvcUrl('novoPerfil').build() }"> <i
						class="material-icons">add</i>
					</a>
				</div>
			</div>

			<div class="row">

				<div class="col s12">
					<table class="centered">
						<tr class="grey lighten-2">
							<td><b>Role</b></td>
							<td><b>Descrição</b></td>
							<td colspan="2"><b>Ação</b></td>
						</tr>
						<c:forEach items="${listaPaginada.content}" var="perfil">
							<tr>
								<td>${perfil.authority}</td>
								<td>${perfil.descricao}</td>
								<td class="center-align"> 
								<a
									class="btn-floating blue"
									href="${s:mvcUrl('editarPerfil').arg(0, perfil.authority).build() }"><i
										class="material-icons">edit</i></a>


									<button href="#modalExcluir"
										class="modal-excluir modal-trigger btn-floating red"
										data-descr="${perfil.descricao }" data-tabela="perfis"
										data-id="${perfil.authority }">
										<i class="material-icons">delete</i>
										<f:form
											action="${s:mvcUrl('apagarPerfil').arg(0, perfil.authority).build() }"
											method="POST">
										</f:form>
									</button></td>
							</tr>
						</c:forEach>
					</table>



				</div>

			</div>
			<%@ include file="../base/paginacao.jsp"%>
			<%@ include file="../base/modalExcluir.jsp"%>

		</div>

	</div>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/modalExcluir.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 3000);
	</script>
</body>

</html>