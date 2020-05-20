 <!--Fale Conosco-->
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
 <div class="fale-conosco" id="fale-conosco">
  <div class="container center">
    <h1 class="titulo">Fale Conosco</h1>
    <br><br>
    <div class="row">
      <div class="col s6 formulario">
        <f:form class="col s12" method="POST"
					action="${s:mvcUrl('contatoViaSite').build() }" modelAttribute="contatoSiteForm">
          <div class="row">

            <div class="input-field col s12">
              <input id="nome" name="nome" type="text" class="validate">
              <label for="nome">Nome</label>
            </div>

            <div class="input-field col s12">
              <input id="email" name="email" type="text" class="validate">
              <label for="email">E-mail</label>
            </div>

            <div class="input-field col s12">
              <input id="assunto" name="assunto" type="text" class="validate">
              <label for="assunto">Assunto</label>
            </div>


              <div class="input-field col s12">
                <textarea id="mensagem" name="mensagem" class="materialize-textarea"></textarea>
                <label for="mensagem">Mensagem</label>
              </div>


              <div class="input-field col s12">
                <input type="submit" value="Enviar" class="left btn botao">
              </div>
          </div>
        </f:form>
      </div>

      <div class="col s6">
        <div class="mapa">
          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.4020670091854!2d-46.53172074892907!3d-23.66157537111153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce42890ae627ef%3A0x934856e70030c41a!2sFAPEN%20-%20Faculdade%20Pent%C3%A1gono!5e0!3m2!1spt-BR!2sbr!4v1570217487451!5m2!1spt-BR!2sbr" width="396" height="396" frameborder="0" allowfullscreen=""></iframe>
        </div>
      </div>
    </div>
  </div>
</div>