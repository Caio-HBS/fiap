<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Fintech | Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/styles.css" />
    <link rel="shortcut icon" href="./resources/favicon.png" type="image/png" />
  </head>
  <body class="index-cover">
    <%@include file="includes/navbar-simple.jsp" %>
    <main class="container d-flex justify-content-center align-items-center centralize">
      <div class="col-12 col-md-6 col-lg-4">
        <form
          action="login"
          method="post"
          class="text-white bg-light-subtle p-3 rounded-3"
        >
          <h1 class="text-black text-center">Fintech | Login</h1>
          <c:if test="${not empty erro}">
            <p class="text-danger text-center"><b>${erro}</b></p>
          </c:if>
          <c:if test="${not empty success}">
            <p class="text-success text-center"><b>${success}</b></p>
          </c:if>
          <div class="mb-3">
            <input
              type="email"
              class="form-control"
              name="email-login"
              placeholder="Seu e-mail"
            />
          </div>
          <div class="mb-3">
            <input
              type="password"
              class="form-control"
              name="senha-login"
              placeholder="Sua senha"
            />
          </div>
          <div class="text-end">
            <a href="register.jsp">Ainda não é cadastrado?</a>
            <button type="submit" class="btn btn-primary btn-lg ms-3"><b>Entrar</b></button>
          </div>
        </form>
      </div>
    </main>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
