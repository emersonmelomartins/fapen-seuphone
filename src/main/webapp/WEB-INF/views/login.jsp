<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seuphone - Última geração em suas mãos.</title>

    <!-- Materialize CSS -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />

    <link rel="stylesheet" href="css/style.css" />
</head>

<body>
    
    <%@ include file="base/menu.jsp"%>
    
    <div class="container">
        <div class="row center">
            <br><br>
            <h1 class="titulo">Acesso Restrito</h1>

            <f:form class="form-signin" method="POST" action="#" >
                <div class="row">
                    <div class="col s4"></div>
                    <div class="col s4">

                        <div class="input-field col s12">
                            <label for="inputUsername">Usuário</label>
                            <input id="inputUsername" name="username" type="text" class="validate" required="true">
                        </div>

                        <div class="input-field col s12">
                            <label for="inputPassword">Senha</label>
                            <input id="inputPassword" name="password" type="password" class="validate" required="true">
                        </div>

                        <div class="input-field col s12">
                            <input type="submit" value="Enviar" class="left btn botao">
                        </div>

                    </div>
                </div>
            </f:form>
        </div>

    </div>



    <!--Materialize JS-->
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/jquery.mask.min.js"></script>
    <script src="js/materialize.min.js"></script>
    <script src="js/main.js"></script>
    <!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>