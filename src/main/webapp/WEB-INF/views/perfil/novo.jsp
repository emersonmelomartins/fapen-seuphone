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
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link type="text/css" rel="stylesheet" href="/css/materialize.min.css" media="screen,projection" />

	<link rel="stylesheet" href="/css/style.css" />
	<link rel="stylesheet" href="/css/animate.css" />

	<style>
		/*Configuração Temporária*/
		.helper-text {
			font-family: Arial, sans-serif;
			text-align: left;
		}
	</style>

</head>

<body>

	<%@ include file="../base/menu.jsp"%>

	<div class="container">

		<div class="row">

			<div class="row">
				<div class="col s12">
					<div class="card ">
						
						<div class="card-content">
							<span class="card-title"><h1 class="titulo">Perfil</h1></span>

							<div class="row">
								<f:form method="POST" action="${s:mvcUrl('salvarPerfil').build() }" modelAttribute="perfil"
									class="col s12">

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">verified_user</i>
											<f:input path="authority" cssClass="validate" placeholder="ROLE_GERENTE" />
											<f:errors path="authority" cssClass="helper-text red-text" />
											<label for="authority">Perfil</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="descricao" cssClass="validate" placeholder="Gerente do Sistema" />
											<f:errors path="descricao" cssClass="helper-text red-text" />
											<label for="descricao">Descrição</label>
										</div>
									</div>

							</div>

						</div>
						<div class="card-action">
							<div class="row">
								<div class="col s2">
									<a href="${s:mvcUrl('listarPerfis').build() }" class="waves-effect waves-light btn red"><i
											class="material-icons left">arrow_back</i>Voltar</a>
								</div>

								<div class="col s2">
									<button type="submit" class="waves-effect waves-light btn green white-text"><i
											class="material-icons left">add</i>Salvar</button>
								</div>
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
</body>

</html>