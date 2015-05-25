<%-- 
    Document   : RespostaFrete
    Created on : 13/05/2015, 09:21:09
    Author     : Meireles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Frete</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://getbootstrap.com/examples/cover/cover.css">
    </head>
    <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="inner cover">
            <h1 class="cover-heading">Resultado:.</h1>
            <p class="lead">CEP de Origem: <% out.println(request.getParameter("CEPOrigem")); %></p><br>
                <p class="lead">CEP de Destino: <% out.println(request.getParameter("CEPDestino")); %></p><br>
                <p class="lead">Peso: <% out.println(request.getParameter("Peso")); %></p><br>
                <p class="lead">Preço SEDEX: <% out.println(request.getAttribute("PrecoSedex")); %></p><br>
                <p class="lead">Preço PAC: <% out.println(request.getAttribute("PrecoPAC"));%></p><br>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
