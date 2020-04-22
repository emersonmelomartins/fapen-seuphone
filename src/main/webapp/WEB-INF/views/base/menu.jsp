
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!--Menu de Navegação-->
<header class="nav-menu">
	<nav class="grey darken-4 z-depth-2">
		<div class="center container">
			<ul class="row">
				<li class="col s4 menu-btn"><a href="#" data-target="slide-out"
					class="sidenav-trigger show-on-large waves-effect"><i
						class="material-icons">menu</i></a></li>
				<li class="col s4"><a href="${s:mvcUrl('paginaHome').build() }"><img
						class="logo responsive-img" src="/img/menu-logo.png" /></a></li>

				<sec:authorize access="!isAuthenticated()">
					<li class="col s2 waves-effect hide-on-small-only"><a
						href="${s:mvcUrl('paginaLogin').build() }">Entrar</a></li>
					<li class="col s2 waves-effect hide-on-small-only"><a href="#">Registrar</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="col s4 waves-effect hide-on-small-only"><a
						class='dropdown-trigger' href='#' data-target='submenu'>Bem
							vindo, <b style="text-transform: uppercase;"><sec:authentication
									property="principal.login" /></b>!<i class="material-icons right">arrow_drop_down</i>
					</a></li>


					<ul id='submenu' class='black-seuphone dropdown-content'>
						<li><a class="black-seuphone white-text waves-effect" href="${s:mvcUrl('paginaPainel').build() }">Acessar Painel</a></li>
						<li><a class="black-seuphone white-text waves-effect" href="${s:mvcUrl('meuPerfil').build() }">Detalhes</a></li>
						<li><a class="black-seuphone white-text waves-effect" href="/logout">Sair</a></li>
					</ul>
				</sec:authorize>
			</ul>


		</div>
	</nav>
</header>

<!--Side Menu-->
<ul id="slide-out" class="sidenav grey darken-4">
	<li><a class="white-text subheader"><b>Menu de Navegação</b></a></li>
	<li><a href="${s:mvcUrl('paginaHome').build() }"
		class="white-text waves-effect">Home</a></li>

	<li><a href="#produtos" class="white-text waves-effect">Produtos</a></li>

	<li><a href="#sobre-nos" class="white-text waves-effect">Sobre
			nós</a></li>

	<li><a href="#como-funciona" class="white-text waves-effect">Como
			Funciona</a></li>

	<li><a href="#fale-conosco" class="white-text waves-effect">Fale
			Conosco</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a class="white-text subheader"><b>Acesso Restrito</b></a></li>
	<sec:authorize access="!isAuthenticated()">
		<li><a href="${s:mvcUrl('paginaLogin').build() }"
			class="white-text waves-effect">Entrar</a></li>
		<li><a href="#" class="white-text waves-effect">Registrar</a></li>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<li><a href="${s:mvcUrl('paginaPainel').build() }" class="white-text waves-effect">Acessar Painel</a></li>
		<li><a href="${s:mvcUrl('meuPerfil').build() }" class="white-text waves-effect">Detalhes</a></li>
		<li><a class="white-text waves-effect" href="/logout">Sair</a></li>
	</sec:authorize>
	<li>
		<div class="divider"></div>
	</li>
</ul>