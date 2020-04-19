<section class="fale-conosco" id="fale-conosco">
  <div class="container">
    <h1 class="titulo">Fale Conosco</h1>

    <div class="formulario">
      <div class="formulario-item">
        <form method="$_GET" action="email_php/index.php" >
          <p>
          <label for="nome">Nome:</label>
          <br />
          <input type="text" name="nome" id="nome" placeholder="João da Silva" required="true">
          </p>

          <p>
            <label for="email">E-mail:</label>
            <br />
            <input type="text" name="email" id="email" placeholder="joaodasilva@gmail.com" required="true">
          </p>

          <p>
            <label for="assunto">Assunto:</label>
            <br />
            <input type="text" name="assunto" id="assunto" placeholder="Assunto importante..." required="true">
          </p>
          <p>
            <label for="mensagem">Mensagem:</label>
            <br />
            <textarea name="mensagem" id="mensagem" cols="50" rows="10" placeholder="Mensagem..."></textarea>
          </p>
          <p>
            <input type="submit" value="Enviar" class="btn">
          </p>

        </form>
      </div>

      <div class="mapa">
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.4020670091854!2d-46.53172074892907!3d-23.66157537111153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce42890ae627ef%3A0x934856e70030c41a!2sFAPEN%20-%20Faculdade%20Pent%C3%A1gono!5e0!3m2!1spt-BR!2sbr!4v1570217487451!5m2!1spt-BR!2sbr" width="396" height="396" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
      </div>

    </div>

  </div>
</section>