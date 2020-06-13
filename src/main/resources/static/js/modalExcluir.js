$(".modal-excluir").click(function() {
	
    var button    = $(this);
    var id = button.data('id');
    var descricao = button.data('descr');
    var tabela = button.data('tabela');
    var modal     = $("#modalExcluir");
    
    if(descricao == 'estorno') {
    	modal.find('.modal-content h5').html(`CONFIRMAÇÃO DE ESTORNO`);
    	modal.find('.modal-content p').html(`<span style="color: red;">O registro não poderá ser recuperado.</span> <br />
				Deseja realmente estornar o pedido? <br /> 
				ID do Pedido:<b> ${id} </b> <br/>`);
    } else {
    	
    	modal.find('.modal-content p').html(`<span style="color: red;">O registro não poderá ser recuperado.</span> <br />
    			Deseja realmente excluir? <br /> 
    			ID:<b> ${id} </b> <br/>
    	Descrição: <b> ${descricao} </b>`);
    }


    $('#btnModalSim').click(function(){
    	//$(location).attr("href", `/${tabela}/${id}/excluir`);
        $(button).find('form').submit();
    });
    
    modal.modal('open');
});