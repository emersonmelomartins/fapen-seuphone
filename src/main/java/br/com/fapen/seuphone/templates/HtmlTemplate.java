package br.com.fapen.seuphone.templates;

public class HtmlTemplate {

	
	public static String recuperarSenha(String token) {
		String conteudo = "<h1>Recuperar Senha</h1>"
				+ "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
				+ "<a style='background-color: purple; color: white; border-radius: 10px; padding: 10px; margin-bottom: 20px; font-weight: bold; text-transform: uppercase; text-decoration: none;' href='http://localhost:8080/recuperar-senha?token="+token+"'>Clique aqui</a>"
				+ "<p>Seuphone &copy; - 2020</p>";
		return conteudo;
	}
}
