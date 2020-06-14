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

	<%@ include file="base/menu.jsp"%>

	<div style="margin-top: 60px;" class="container">
		<div class="row center">
			<div class="col s2"></div>
			<div class="col s8">
				<h1 class="titulo">Ocorreu um erro</h1>
				<p></p>
				<table class="centered">
				
					<tr>
						<td>Data de Ocorrência</td>
						<td><fmt:formatDate value="${timestamp}" pattern="dd/MM/yyyy HH:mm"/> </td>
					</tr>
					<tr>
						<td>Erro Encontrado</td>
						<td>${error}</td>
					</tr>
					<tr>
						<td>Código de Status</td>
						<td>${status}</td>
					</tr>
					<tr>
						<td>Mensagem</td>
						<td>${message}</td>
					</tr>
					<tr>
						<td>Exception</td>
						<td>${exception}</td>
					</tr>
					<tr>
						<td>Trace</td>
						<td><pre>${trace}</pre></td>
					</tr>
				</table>

			</div>
			<div class="col s2"></div>s
		</div>
	</div>

	<%@ include file="base/rodape.jsp"%>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/modalExcluir.js"></script>

</body>

</html>
