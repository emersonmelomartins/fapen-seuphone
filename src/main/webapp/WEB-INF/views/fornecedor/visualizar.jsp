<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

		<div class="row">
			<br> <br>
			<h1 class="titulo">Fornecedor</h1>

			<br> <br>

			<c:forEach items="fornecedor">

				<div class="row">

					<div class="col s3">

					</div>
					<div class="col s6">
						<div class="card">
							<br>
							<div class="card-content">
								<h5 style="text-transform: uppercase;" class="black-text">
									${fornecedor.razaoSocial }
								</h5>
								<hr />

								<table class="striped">
									<tbody>
										<tr>
											<td>ID:</td>
											<td>${fornecedor.id}</td>
										</tr>
										<tr>
											<td>CNPJ:</td>
											<td class="fmt-cnpj">${fornecedor.cnpj}</td>
										</tr>
										<tr>
											<td>Email:</td>
											<td>${fornecedor.email}</td>
										</tr>
										<tr>
											<td>Telefone:</td>
											<td class="fmt-tel">${fornecedor.tel}</td>
										</tr>
										<tr>
											<td>Categoria Produto: </td>
											<td>
												${fornecedor.categoriaProduto}
											</td>
										</tr>
										<tr>
											<td>CEP: </td>
											<td class="fmt-cep">${fornecedor.endereco.cep}</td>
										</tr>
										<tr>
											<td>Logradouro: </td>
											<td>${fornecedor.endereco.logradouro}</td>
										</tr>
										<tr>
											<td>Bairro: </td>
											<td>${fornecedor.endereco.bairro}</td>
										</tr>
										<tr>
											<td>Número: </td>
											<td>${fornecedor.endereco.numero}</td>
										</tr>
										<tr>
											<td>UF: </td>
											<td>${fornecedor.endereco.uf}</td>
										</tr>
										<tr>
											<td>Cidade: </td>
											<td>${fornecedor.endereco.cidade}</td>
										</tr>
										<tr>
											<td>Complemento: </td>
											<td>${fornecedor.endereco.complemento}</td>
										</tr>
										<tr>
											<td>Status:</td>
											<td>
												<c:if test="${!fornecedor.inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if>
												<c:if test="${fornecedor.inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if>

											</td>
										</tr>
									</tbody>
								</table>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="col s3"></div>


	</div>



	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<a href="${s:mvcUrl('listarFornecedores').build() }" class="waves-effect waves-light btn red"><i class="material-icons left">arrow_back</i>Voltar</a>
		</div>
		<div class="col s3"></div>
	</div>
	</div>
	</div>

	<%@ include file="../base/rodape.jsp"%>

	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
</body>

</html>