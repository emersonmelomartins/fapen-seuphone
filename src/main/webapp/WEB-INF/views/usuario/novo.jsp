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
							<span class="card-title"><h1 class="titulo">Usuário</h1></span>

							<div class="row">
								<f:form method="POST" action="${s:mvcUrl('salvarUsuario').build() }" modelAttribute="usuario"
									class="col s12">
									<f:hidden path="idLogin" />

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">account_circle</i>
											<f:input path="login" cssClass="validate" placeholder="joao.silva" />
											<f:errors path="login" cssClass="helper-text red-text" />
											<label for="login">Login</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">lock</i>
											<f:input path="senha" type="password" cssClass="validate" placeholder="******" />
											<f:errors path="senha" cssClass="helper-text red-text" />
											<label for="senha">Senha</label>
										</div>
									</div>


									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">person</i>
											<f:input path="pessoa.nome" cssClass="validate" placeholder="João da Silva" />
											<f:errors path="pessoa.nome" cssClass="helper-text red-text" />
											<label for="pessoa.nome">Nome Completo</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">email</i>
											<f:input path="email" cssClass="validate" placeholder="joao.silva@gmail.com" />
											<f:errors path="email" cssClass="helper-text red-text" />
											<label for="email">E-mail</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">assignment_ind</i>
											<f:input path="pessoa.cpf" cssClass="validate fmt-cpf" placeholder="123.456.789-10" />
											<f:errors path="pessoa.cpf" cssClass="helper-text red-text" />
											<label for="pessoa.cpf">CPF</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">date_range</i>
											<f:input path="pessoa.dtNascimento" cssClass="validate datepicker" placeholder="01/02/1990" />
											<f:errors path="pessoa.dtNascimento" cssClass="helper-text red-text" />
											<label for="pessoa.dtNascimento">Data Nascimento</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">wc</i>
											<f:select path="pessoa.sexo" id="pessoa.sexo" cssClass="validate">
												<f:option value="">Selecione o Sexo</f:option>
												<f:option value="M">Masculino</f:option>
												<f:option value="F">Feminino</f:option>
											</f:select>
											<f:errors path="pessoa.sexo" cssClass="helper-text red-text" />
											<label for="pessoa.sexo">Sexo</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">phone</i>
											<f:input path="pessoa.telefone" cssClass="validate fmt-tel" placeholder="(11)1234-5678" />
											<f:errors path="pessoa.telefone" cssClass="helper-text red-text" />
											<label for="pessoa.telefone">Telefone</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">smartphone</i>
											<f:input path="pessoa.celular" cssClass="validate fmt-cel" placeholder="(11)91234-5678" />
											<f:errors path="pessoa.celular" cssClass="helper-text red-text" />
											<label for="pessoa.celular">Celular</label>
										</div>
									</div>

							</div>

						</div>
						<div class="card-action">
							<div class="row">
								<div class="col s2">
									<a href="${s:mvcUrl('listarUsuarios').build() }" class="waves-effect waves-light btn red"><i
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