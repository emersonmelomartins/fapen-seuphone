$(".modal-excluir").click(function() {
	
    var button    = $(this);
    var id = button.data('id');
    var descricao = button.data('descr');
    var tabela = button.data('tabela');
    var modal     = $("#modalExcluir");

    modal.find('.modal-content p').html(`<span style="color: red;">O registro não poderá ser recuperado.</span> <br />
    									Deseja realmente excluir este item? <br /> 
    									ID:<b> ${id} </b> <br/>
    									Descrição: <b> ${descricao} </b>`);

    $('#btnModalSim').click(function(){
    	$(location).attr("href", `/${tabela}/${id}/apagar`);
    });
    
    modal.modal('open');
});