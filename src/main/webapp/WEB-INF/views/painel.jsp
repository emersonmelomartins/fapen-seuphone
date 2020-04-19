<!DOCTYPE html>
<html lang="pt-BR">
<head>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Seuphone - Última geração em suas mãos.</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="css/style.css" />
</head>

<body>

	<%@ include file="base/menu.jsp"%>

	<div class="container">
		<div class="row center">
			<br> <br>
			<h1 class="titulo">Painel Administrativo</h1>
			<br> <br>

			<div class="row">
				<div class="col s6">
					<div style="padding: 35px;" align="center" class="card">
						<div class="row">
							<div class="left card-title">
								<b>Gerenciamento de Usuário</b>
							</div>
						</div>

						<div class="row">
							<a href="#!">
								<div style="padding: 30px;"
									class="col s5 waves-effect">
									<i class="grey-text text-darken-1 large material-icons">person</i>
									<span class="grey-text text-darken-2">
										<h5>Usuários</h5>
									</span>
								</div>
							</a>
							<div class="col s1">&nbsp;</div>
							<div class="col s1">&nbsp;</div>

							<a href="#!">
								<div style="padding: 30px;"
									class="col s5 waves-effect">
									<i class="grey-text text-darken-1 large material-icons">people</i>
									<span class="grey-text text-darken-2">
										<h5>Perfis</h5>
									</span>
								</div>
							</a>
						</div>
					</div>
				</div>

				<div class="col s6">
					<div style="padding: 35px;" align="center" class="card">
						<div class="row">
							<div class="left card-title">
								<b>Gerenciamento de Produto</b>
							</div>
						</div>
						<div class="row">
							<a href="${s:mvcUrl('listarProdutos').build() }">
								<div style="padding: 30px;"
									class="col s5 waves-effect">
									<i class="grey-text text-darken-1 large material-icons">store</i>
									<span class="grey-text text-darken-2">
										<h5>Produtos</h5>
									</span>
								</div>
							</a>

							<div class="col s1">&nbsp;</div>
							<div class="col s1">&nbsp;</div>

							<a href="#!">
								<div style="padding: 30px;"
									class="col s5 waves-effect">
									<i class="grey-text text-darken-1 large material-icons">assignment</i>
									<span class="grey-text text-darken-1">
										<h5>Pedidos</h5>
									</span>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>



	<!--Materialize JS-->
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/jquery.mask.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<script src="js/main.js"></script>
	<!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>