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

</head>

<body>

	<%@ include file="../base/menu.jsp"%>

<div class="container">

		<div class="row">
			<div class="col s3"></div>
			<div class="col s6">
				<h3>Dados do Perfil</h3>
				<div class="card">
					<div class="card-image black">
						<div class="white-text center-align">
							<i style="padding: 30px;" class="large material-icons">assignment_ind</i>
						</div>
						<a class="btn-floating halfway-fab waves-effect waves-light blue"><i
							class="material-icons">edit</i></a>
					</div>
					<div class="card-content">

						<c:forEach items="perfil">

							<h5 style="text-transform: uppercase;" class="black-text">
								${perfil.login }
							</h5>
							<hr />
							<h6>Nome</h6>
							<p>
								${perfil.pessoa.nome }
							</p>
							<h6>Data Nascimento</h6>
							<p>
								${perfil.pessoa.dtNascimento }
							</p>
							<h6>E-mail</h6>
							<p>
								${perfil.email }
							</p>
							<h6>CPF</h6>
							<p class="fmt-cpf">
								${perfil.pessoa.cpf }
							</p>
							<h6>Sexo</h6>
							<p>
								${perfil.pessoa.sexo }
							</p>
							<h6>Telefone</h6>
							<p>
								${perfil.pessoa.telefone }
							</p>
							<h6>Celular</h6>
							<p>
								${perfil.pessoa.celular }
							</p>

							<h5>Permissões</h5>
							<div class="chip blue">ROLE_ADMIN</div>
							<div class="chip red">ROLE_GERENTE</div>
							<div class="chip green">ROLE_VENDEDOR</div>
							<div class="chip deep-purple">ROLE_ESTOQUE</div>
							<div class="chip teal">ROLE_NOTAFISCAL</div>
							<div class="chip yellow">ROLE_USUARIO</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<div class="col s3"></div>
		</div>

	</div>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 3000);
	</script>
	<!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>
