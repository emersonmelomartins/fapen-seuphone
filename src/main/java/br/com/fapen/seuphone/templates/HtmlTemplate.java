package br.com.fapen.seuphone.templates;

import br.com.fapen.seuphone.forms.ContatoSiteForm;

public class HtmlTemplate {

	public static final String link = "http://localhost:8080";
	
	public static String recuperarSenha(String token, String usuario) {
		String conteudo = "<div style='font-family: Arial; text-align: center; margin: 0 auto; max-width: 600px; padding: 20px;'>\n" + 
				"  <img src='cid:logo-seuphone' alt='Logo Seuphone' />\n" + 
				"  <hr />\n" + 
				"  <h2>Recuperação de Senha</h2>\n" + 
				"  <p>Olá, <b>"+ usuario +"</b></p>\n" + 
				"  <p align='justify'>Você solicitou a recuperação a recuperação de senha, basta você clicar no botão abaixo e informar sua nova senha:</p>\n" + 
				"  <br />\n" + 
				"  <a href='"+ link +"/recuperar-senha?token="+ token +"' style='padding: 10px 30px; background-color: #007bff; color: white; border: none; border-radius: 10px; text-transform: uppercase; font-weight: bold; cursor: pointer; box-shadow: 3px 3px 5px rgba(0, 0, 0, .250); text-decoration: none; display: block; max-width: 300px; margin: 20px auto;'>Recuperar Senha</a>" + 
				"  <hr />\n" + 
				"  <footer>\n" + 
				"    <p style='font-size: 12px;'>Seuphone &copy; - 2020</p>\n" + 
				"  </footer>\n" + 
				"</div>";
		return conteudo;
	}
	
	public static String contatoViaSite(ContatoSiteForm contatoSiteForm) {
		String conteudo = "<div style='font-family: Arial; text-align: center; margin: 0 auto; max-width: 600px; padding: 20px;'>\n" + 
				"  <img src='cid:logo-seuphone' alt='Logo Seuphone' />\n" + 
				"  <hr />\n" + 
				"  <h2>Contato via Site</h2>\n" + 
				"  <p align='center'>Você recebeu uma mensagem via site, segue abaixo:</p>\n" + 
				"  <br />\n" + 
				"  <b>Nome: </b> " + contatoSiteForm.getNome() + "<br />" +
				"  <b>E-mail: </b> " + contatoSiteForm.getEmail() +" <br />" +
				"  <b>Assunto: </b> " + contatoSiteForm.getAssunto() + "<br />" +
				"  <b>Mensagem: </b> " + contatoSiteForm.getMensagem() + "<br />" +
				"  <hr />\n" + 
				"  <footer>\n" + 
				"    <p style='font-size: 12px;'>Seuphone &copy; - 2020</p>\n" + 
				"  </footer>\n" + 
				"</div>";
		return conteudo;
	}
}
