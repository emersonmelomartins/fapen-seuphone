 <%@ page contentType="text/html; charset=UTF-8" %>
  <!--Introdução-->
  <div class="introducao">
    <div class="container">
    
    <c:if test="${mensagemSucesso != null }">
		<div class="status-message row">
			<div class="center col s4 green white-text animated bounceInLeft">
				<p>${mensagemSucesso }</p>
			</div>
		</div>
	</c:if>
	<c:if test="${mensagemErro != null }">
		<div class="status-message row">
			<div class="center col s4 red white-text animated bounceInLeft">
				<p>${mensagemErro }</p>
			</div>
		</div>
	</c:if>
    
      <div class="section">
        <div class="row">
          <h1 class="white-text col s6 l5">Última geração em suas mãos.</h1>
        </div>
      </div>
    </div>
  </div>