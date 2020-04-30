$(document).ready(
		function() {

			function limpa_formulário_cep() {
				// Limpa valores do formulário de cep.
				$("#endereco\\.logradouro").val("");
				$("#endereco\\.bairro").val("");
				$("#endereco\\.cidade").val("");
				$("#endereco\\.uf").val("");
			}

			// Quando o campo cep perde o foco.
			$("#endereco\\.cep").blur(
					function() {

						// Nova variável "cep" somente com dígitos.
						var cep = $(this).val().replace(/\D/g, '');

						// Verifica se campo cep possui valor informado.
						if (cep != "") {

							// Expressão regular para validar o CEP.
							var validacep = /^[0-9]{8}$/;

							// Valida o formato do CEP.
							if (validacep.test(cep)) {

								// Preenche os campos com "..." enquanto
								// consulta webservice.
								$("#endereco\\.logradouro").val("...");
								$("#endereco\\.bairro").val("...");
								$("#endereco\\.cidade").val("...");
								$("#endereco\\.uf").val("...");

								// Consulta o webservice viacep.com.br/
								$.getJSON("https://viacep.com.br/ws/" + cep
										+ "/json/?callback=?", function(dados) {

									if (!("erro" in dados)) {
										// Atualiza os campos com os valores da
										// consulta.
										$("#endereco\\.logradouro").val(dados.logradouro);
										$("#endereco\\.bairro").val(dados.bairro);
										$("#endereco\\.cidade").val(dados.localidade);
										$("#endereco\\.uf").val(dados.uf);
									} // end if.
									else {
										// CEP pesquisado não foi encontrado.
										limpa_formulário_cep();
										alert("CEP não encontrado.");
									}
								});
							} // end if.
							else {
								// cep é inválido.
								limpa_formulário_cep();
								alert("Formato de CEP inválido.");
							}
						} // end if.
						else {
							// cep sem valor, limpa formulário.
							limpa_formulário_cep();
						}
					});
		});
