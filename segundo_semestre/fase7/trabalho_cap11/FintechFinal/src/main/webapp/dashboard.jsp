<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Dashboard</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./resources/css/styles.css" />
  </head>
  <body class="d-flex flex-column min-vh-100">
    <%@include file="includes/navbar.jsp" %>
    <section class="container-fluid text-center mt-2 mt-sm-0">
      <h3 class="text-start mt-3">&Uacute;ltimos registros</h3>
      <div class="row justify-content-around">
        <div class="col col-12 col-sm-3 bg-dark-subtle rounded-5 mt-1 mt-sm-0 d-none d-sm-block">
          <p><b>&Uacute;ltimo investimento</b></p>
          <p class="h1 pt-2">R$438,98</p>
          <p>Nome do investimento</p>
        </div>
        <div class="col col-12 col-sm-3 bg-dark-subtle rounded-5 mt-1 mt-sm-0">
          <p><b>&Uacute;ltima despesa</b></p>
          <p class="h1 pt-2">R$438,98</p>
          <p>Nome da despesa</p>
        </div>
        <div class="col col-12 col-sm-3 bg-dark-subtle rounded-5 mt-1 mt-sm-0 d-none d-sm-block">
          <p><b>&Uacute;ltima receita</b></p>
          <p class="h1 pt-2">R$438,98</p>
          <p>Nome da receita</p>
        </div>
      </div>
    </section>
    <hr />
    <section class="container-fluid text-center pt-2 mb-5 mb-md-0">
      <h3 class="text-start">Serviços</h3>
      <div class="row gap-1 justify-content-around">
        <div class="col col-5 col-md-2 border border-1 p-2">
          <a href="operacoes.jsp" class="text-decoration-none">
            <img
              src="./resources/images/icons/check-list.png"
              alt="Uma prancheta com marcações"
              class="img-fluid"
            />
            <p class="text-black mt-2 mb-0 h5">
              Minhas opera&ccedil;&otilde;es
            </p>
          </a>
        </div>
        <div class="col col-5 col-md-2 border border-1 p-2">
          <a href="investimentos.jsp" class="text-decoration-none">
            <img
              src="./resources/images/icons/add-task.png"
              alt="Uma pilha de arquivos vista de cima"
              class="img-fluid"
            />
            <p class="text-black mt-2 mb-0 h5">Meus investimentos</p>
          </a>
        </div>
        <div class="col col-5 col-md-2 border border-1 p-2">
          <a href="meu-perfil.jsp" class="text-decoration-none">
            <img
              src="./resources/images/icons/profile.png"
              alt="Uma lupa"
              class="img-fluid"
            />
            <p class="text-black mt-2 mb-0 h5">Meu perfil</p>
          </a>
        </div>
        <div class="col col-5 col-md-2 border border-1 p-2">
          <a href="noticias.jsp" class="text-decoration-none">
            <img
              src="./resources/images/icons/new-features.png"
              alt="Uma mão indicando novidades"
              class="img-fluid"
            />
            <p class="text-black mt-2 mb-0 h5">Not&iacute;cias e Novidades</p>
          </a>
        </div>
      </div>
    </section>
    <%@include file="includes/footer.jsp" %>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
