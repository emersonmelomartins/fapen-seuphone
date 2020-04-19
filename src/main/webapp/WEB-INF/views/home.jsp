<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Seuphone - Última geração em suas mãos.</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="css/style.css" />
</head>
<body>

<div class="fixed-action-btn">
  <a class="btn-floating btn-large black-seuphone" href="#topo">
    <i class="large material-icons">arrow_upward</i>
  </a>
</div>
	<div id="topo"></div>
	<%@ include file="base/menu.jsp"%>
	<%@ include file="base/introducao.jsp"%>
	<%@ include file="base/produtos.jsp"%>
	<%@ include file="base/como-funciona.jsp"%>
	<%@ include file="base/sobre.jsp"%>
	<%@ include file="base/fale-conosco.jsp"%>
	<%@ include file="base/rodape.jsp"%>


	<!--Materialize JS-->
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/jquery.mask.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<script src="js/main.js"></script>
	<!-- <script src="/js/modalExcluir.js"></script> -->

</body>
</html>