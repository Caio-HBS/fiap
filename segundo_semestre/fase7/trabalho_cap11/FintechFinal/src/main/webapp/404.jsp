<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Fintech | 404</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Iceberg&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./resources/css/styles.css" />
  </head>
  <body class="d-flex flex-column min-vh-100 index-cover">
    <%@include file="includes/navbar.jsp" %>
    <main class="container">
      <div
        class="d-flex flex-column justify-content-center align-items-center vh-100"
      >
        <h1 class="text-white error-title"><b>404</b></h1>
        <p class="h1 text-white m-5 error-message">
          PARECE QUE O RECURSO QUE VOC&Ecirc; EST&Aacute; PROCURANDO N&Atilde;O
          EXISTE.
        </p>
        <a href="dashboard" class="btn btn-success btn-lg m-5"
          ><b>Voltar para o dashboard</b></a
        >
      </div>
    </main>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
