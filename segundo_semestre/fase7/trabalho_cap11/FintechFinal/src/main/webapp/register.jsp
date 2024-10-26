<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Fintech | Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/styles.css" />
  </head>
  <body class="index-cover">
    <%@include file="includes/navbar-simple.jsp" %>
    <main
      class="container d-flex justify-content-center align-items-center centralize"
    >
      <div class="col-12 col-md-6 col-lg-4">
        <form
          action="register"
          method="post"
          class="text-white bg-light-subtle p-3 rounded-3 needs-validation"
        >
          <h1 class="text-black text-center mb-4">Fintech | Registro</h1>
          <c:if test="${not empty erro}">
            <p class="text-danger text-center"><b>${erro}</b></p>
          </c:if>
          <div class="d-flex mb-3">
            <input
              type="text"
              class="form-control"
              name="nome-registro"
              maxlength="30"
              placeholder="Seu nome"
              required
            />
            <input
              type="text"
              class="form-control ms-3"
              name="sobrenome-registro"
              maxlength="30"
              placeholder="Seu sobrenome"
              required
            />
          </div>
          <div class="mb-3">
            <input
              type="email"
              class="form-control"
              name="email-registro"
              maxlength="50"
              placeholder="Seu e-mail"
              required
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">@</span>
            <input
              type="text"
              class="form-control"
              name="nome-usuario-registro"
              maxlength="20"
              placeholder="Seu nome de usu&aacute;rio"
              required
            />
          </div>
          <div class="input-group mb-3">
            <input
              type="date"
              class="form-control"
              name="dt-nascimento-registro"
              required
            />
            <div class="input-group-text ms-3">
              <input
                class="form-check-input mt-0"
                type="checkbox"
                value="true"
                name="novidades-registro"
              />
            </div>
            <input
              type="text"
              class="form-control"
              value="Receber novidades"
              readonly
            />
          </div>
          <div class="d-flex mb-3">
            <input
              type="password"
              class="form-control"
              name="senha-registro"
              maxlength="20"
              placeholder="Sua senha"
              required
            />
            <input
              type="password"
              class="form-control ms-3"
              name="senha-confirmar-registro"
              maxlength="20"
              placeholder="Confirme sua senha"
              required
            />
          </div>
          <div class="d-flex mb-3">
            <select class="form-select" name="pronomes-registro">
              <option selected disabled>Seus pronomes</option>
              <option value="Ele/Dele">Ele/Dele</option>
              <option value="Ela/Dela">Ela/dela</option>
              <option value="">Outros</option>
            </select>
            <input
              type="text"
              class="form-control ms-3"
              name="apelido-registro"
              placeholder="Seu apelido"
            />
          </div>
          <div class="text-end">
            <a href="login.jsp">J&aacute; tem uma conta?</a>
            <button type="submit" class="btn btn-success btn-lg ms-3">
              <b>Registrar-se</b>
            </button>
          </div>
        </form>
      </div>
    </main>
    <script src="resources/js/script.js"></script>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
