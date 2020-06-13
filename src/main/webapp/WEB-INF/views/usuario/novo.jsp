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
								<f:form method="POST"
									action="${s:mvcUrl('salvarUsuario').build() }"
									modelAttribute="usuarioForm" class="col s12">
									<f:hidden path="usuario.idLogin" />
									<f:hidden path="inclusao" />
									<f:hidden path="usuario.caminhoFoto" />

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">account_circle</i>
											<f:input path="usuario.login" cssClass="validate"
												placeholder="joao.silva" />
											<f:errors path="usuario.login"
												cssClass="helper-text red-text" />
											<label for="usuario.login">Login</label>
										</div>


									</div>

									<c:if test="${usuarioForm.inclusao }">
										<div class="row">
											<div class="input-field col s6">
												<i class="material-icons prefix">lock</i>
												<f:input path="usuario.senha" type="password"
													cssClass="validate" placeholder="******" />
												<f:errors path="usuario.senha"
													cssClass="helper-text red-text" />
												<label for="usuario.senha">Senha</label>
											</div>

											<div class="input-field col s6">
												<i class="material-icons prefix">lock</i>
												<f:input path="confirmaSenha" type="password"
													cssClass="validate" placeholder="******" />
												<f:errors path="confirmaSenha"
													cssClass="helper-text red-text" />
												<label for="confirmaSenha">Confirmar Senha</label>
											</div>
										</div>
									</c:if>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">person</i>
											<f:input path="usuario.pessoa.nome" cssClass="validate"
												placeholder="João da Silva" />
											<f:errors path="usuario.pessoa.nome"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.nome">Nome Completo</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">email</i>
											<f:input path="usuario.email" cssClass="validate"
												placeholder="joao.silva@gmail.com" />
											<f:errors path="usuario.email"
												cssClass="helper-text red-text" />
											<label for="usuario.email">E-mail</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">assignment_ind</i>
											<f:input path="usuario.pessoa.cpf"
												cssClass="validate fmt-cpf" placeholder="123.456.789-10" />
											<f:errors path="usuario.pessoa.cpf"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.cpf">CPF</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">date_range</i>
											<f:input path="usuario.pessoa.dtNascimento"
												cssClass="validate datepicker" placeholder="01/02/1990" />
											<f:errors path="usuario.pessoa.dtNascimento"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.dtNascimento">Data
												Nascimento</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">wc</i>
											<f:select path="usuario.pessoa.sexo" cssClass="validate">
												<f:option value="">Selecione o Sexo</f:option>
												<f:option value="M">Masculino</f:option>
												<f:option value="F">Feminino</f:option>
											</f:select>
											<f:errors path="usuario.pessoa.sexo"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.sexo">Sexo</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">phone</i>
											<f:input path="usuario.pessoa.telefone"
												cssClass="validate fmt-tel" placeholder="(11)1234-5678" />
											<f:errors path="usuario.pessoa.telefone"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.telefone">Telefone</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">smartphone</i>
											<f:input path="usuario.pessoa.celular"
												cssClass="validate fmt-cel" placeholder="(11)91234-5678" />
											<f:errors path="usuario.pessoa.celular"
												cssClass="helper-text red-text" />
											<label for="usuario.pessoa.celular">Celular</label>
										</div>
									</div>



									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:select path="usuario.inativo" id="usuario.inativo"
												cssClass="validate">
												<f:option value="false">Ativo</f:option>
												<f:option value="true">Inativo</f:option>
											</f:select>
											<f:errors path="usuario.inativo"
												cssClass="helper-text red-text" />
											<label for="usuario.inativo">Status do Usuário</label>
										</div>
									</div>

									<br />
									<label for="perfil">Perfil</label>
									<div class="row">
										<div class="col s6">

											<select id="perfilSel">
												<option value="">Selecione</option>
												<c:forEach items="${listaPerfis }" var="perfil">
													<option value="${perfil.authority }">${perfil.descricao }</option>
												</c:forEach>
											</select>
											<f:errors path="listaPerfil" cssClass="helper-text red-text" />
										</div>
										<div class="col s2">
											<a class="btn" id="btnAddPerfil">Adicionar</a>

										</div>
										<table class="responsive-table" id="tablePerfis">
											<thead>
												<tr>
													<th>Nome</th>
													<th>Descrição</th>
													<th class="center-align">Ações</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${usuarioForm.listaPerfil }" var="perfil"
													varStatus="status">
													<tr>
														<f:hidden path="listaPerfil[${status.index }].authority" />
														<f:hidden path="listaPerfil[${status.index }].descricao" />
														<td>${perfil.authority }</td>
														<td>${perfil.descricao }</td>
														<td><a class="btn-small red btnDeletePerfil"><i
																class="material-icons">delete</i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
							</div>

						</div>
						<div class="card-action">
							<div class="row">

								<a href="${s:mvcUrl('listarUsuarios').build() }"
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
		$(document)
				.ready(
						function() {
							$("#btnAddPerfil")
									.click(
											function() {
												var count = $("#tablePerfis tbody tr").length;
												var table = $("#tablePerfis tbody");
												var cHtml = "";

												cHtml += '<tr>';
												cHtml += '<input type="hidden" id="listaPerfil['
														+ count
														+ '].authority" name="listaPerfil['
														+ count
														+ '].authority" value="'
														+ $("#perfilSel").val()
														+ '" />';
												cHtml += "<input type='hidden' id='listaPerfil["
														+ count
														+ "].descricao' name='listaPerfil["
														+ count
														+ "].descricao' value='"
														+ $(
																"#perfilSel option:selected")
																.text()
														+ "' />";
												cHtml += "<td>"
														+ $("#perfilSel").val()
														+ "</td>";
												cHtml += "<td>"
														+ $(
																"#perfilSel option:selected")
																.text()
														+ "</td>";
												cHtml += "<td class='center-align'><a class='btn-small red btnDeletePerfil' title='excluir'><i class='material-icons'>delete</i></a></td>";

												cHtml += "</tr>";

												var perfilSelecionado = $(
														"#perfilSel option:selected")
														.val();
												if (!perfilSelecionado) {
													alert("É necessário selecionar um perfil válido!");
												} else {
													table.append("chtml"
															+ cHtml);
												}
											});

							$("#tablePerfis tbody").on("click",
									"a.btnDeletePerfil", function(botao) {
										$(this).closest("tr").remove();
									})
						});
	</script>
</body>

</html>