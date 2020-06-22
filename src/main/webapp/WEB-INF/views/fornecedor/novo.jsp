<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
							<span class="card-title"><h1 class="titulo">Fornecedor</h1></span>

							<div class="row">
								<f:form method="POST"
									action="${s:mvcUrl('salvarFornecedor').build() }"
									modelAttribute="fornecedor" class="col s12">
									<f:hidden path="id" />

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="razaoSocial" cssClass="validate"
												placeholder="Apple Computadores" />
											<f:errors path="razaoSocial" cssClass="helper-text red-text" />
											<label for="razaoSocial">Razão Social</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="cnpj" cssClass="validate fmt-cnpj"
												placeholder="12.345.678/0001-23" />
											<f:errors path="cnpj" cssClass="helper-text red-text" />
											<label for="cnpj">CNPJ</label>
										</div>
									</div>


									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">email</i>
											<f:input path="email" cssClass="validate"
												placeholder="contato@apple.com.br" />
											<f:errors path="email" cssClass="helper-text red-text" />
											<label for="email">E-mail</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">phone</i>
											<f:input path="tel" cssClass="validate fmt-tel"
												placeholder="(11)1234-5678" />
											<f:errors path="tel" cssClass="helper-text red-text" />
											<label for="tel">Telefone</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="categoriaProduto" cssClass="validate"
												placeholder="Smartphone" />
											<f:errors path="categoriaProduto"
												cssClass="helper-text red-text" />
											<label for="categoriaProduto">Categoria Produto</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.cep" cssClass="validate fmt-cep"
												placeholder="09111-222" />
											<f:errors path="endereco.cep" cssClass="helper-text red-text" />
											<label for="endereco.cep">CEP</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.logradouro" cssClass="validate"
												placeholder="Rua Ipiranga" />
											<f:errors path="endereco.logradouro"
												cssClass="helper-text red-text" />
											<label for="endereco.logradouro">Logradouro</label>
										</div>
									</div>
									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.bairro" cssClass="validate"
												placeholder="Vila Matriz" />
											<f:errors path="endereco.bairro"
												cssClass="helper-text red-text" />
											<label for="endereco.bairro">Bairro</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.numero" cssClass="validate"
												type="number" placeholder="1234" />
											<f:errors path="endereco.numero"
												cssClass="helper-text red-text" />
											<label for="endereco.numero">Número</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:select path="endereco.uf" id="endereco.uf"
												cssClass="validate">
												<f:option value="">Selecione um estado</f:option>
												<f:option value="AC">AC</f:option>
												<f:option value="AL">AL</f:option>
												<f:option value="AM">AM</f:option>
												<f:option value="AP">AP</f:option>
												<f:option value="BA">BA</f:option>
												<f:option value="CE">CE</f:option>
												<f:option value="DF">DF</f:option>
												<f:option value="ES">ES</f:option>
												<f:option value="GO">GO</f:option>
												<f:option value="MA">MA</f:option>
												<f:option value="MG">MG</f:option>
												<f:option value="MS">MS</f:option>
												<f:option value="MT">MT</f:option>
												<f:option value="PA">PA</f:option>
												<f:option value="PB">PB</f:option>
												<f:option value="PE">PE</f:option>
												<f:option value="PI">PI</f:option>
												<f:option value="PR">PR</f:option>
												<f:option value="RJ">RJ</f:option>
												<f:option value="RN">RN</f:option>
												<f:option value="RS">RS</f:option>
												<f:option value="RO">RO</f:option>
												<f:option value="RR">RR</f:option>
												<f:option value="SC">SC</f:option>
												<f:option value="SE">SE</f:option>
												<f:option value="SP">SP</f:option>
												<f:option value="TO">TO</f:option>
											</f:select>
											<f:errors path="endereco.uf" cssClass="helper-text red-text" />
											<label for="endereco.uf">UF</label>
										</div>

										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.cidade" cssClass="validate"
												placeholder="São Paulo" />
											<f:errors path="endereco.cidade"
												cssClass="helper-text red-text" />
											<label for="endereco.cidade">Cidade</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="endereco.complemento" cssClass="validate"
												placeholder="Casa do portão branco" />
											<f:errors path="endereco.complemento"
												cssClass="helper-text red-text" />
											<label for="endereco.complemento">Complemento</label>
										</div>
									</div>


									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<div class="row">
											<div class="input-field col s6">
												<i class="material-icons prefix">description</i>
												<f:select path="inativo" id="inativo" cssClass="validate">
													<f:option value="false">Ativo</f:option>
													<f:option value="true">Inativo</f:option>
												</f:select>
												<f:errors path="inativo" cssClass="helper-text red-text" />
												<label for="inativo">Status do Fornecedor</label>
											</div>
										</div>
									</sec:authorize></div>

						</div>
						<div class="card-action">
							<div class="row">
								
									<a href="${s:mvcUrl('listarFornecedores').build() }"
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
	<script src="/js/viacep.js"></script>
</body>

</html>