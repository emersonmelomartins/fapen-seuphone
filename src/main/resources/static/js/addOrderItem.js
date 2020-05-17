function montaGradeItens(retorno) {
	var cHtml = $(retorno).find("#dadosRegistro").html();
	$("#dadosItens").html(cHtml);
	$("select").formSelect();
}
function erroAjax(dadosErro) {
	console.log(dadosErro);
}
$("body").on("click", ".deletaItem", function(event) {
	event.preventDefault();
	$.ajax({
		type : "POST",
		data : $("form").serialize(),
		url : "/pedidos/deletaItem/" + $(this).val(),
		success : montaGradeItens,
		error : erroAjax
	});
});
$("body").on("click", "#btnNovoItem", function(event) {
	event.preventDefault();
	$.ajax({
		type : "POST",
		data : $("form").serialize(),
		url : "/pedidos/novoItem",
		success : montaGradeItens,
		error : erroAjax
	});
});

$("body").on(
		"change",
		"select[name$='produto']",
		function(event) {
			var elementoProduto = $(this);
			var elementoValor = $(this).closest(".row").find(
					"input[name$='valor']");

			$.ajax({
				type : "GET",
				url : "/api/produtos/" + elementoProduto.val(),
				dataType : "json",
				contentType : "application/json; charset=utf-8",
				success : function(dados) {
					console.log(dados);
					elementoValor.val(dados.valor);
				},
				error : erroAjax
			});
		});