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
    <%@include file="includes/navbar.jsp" %>
    <main
        class="container d-flex justify-content-center align-items-center centralize"
    >
      <div class="col-12 col-md-6 col-lg-4">
        <c:if test="${not empty error}">
          <p class="text-center text-danger">${erro}</p>
        </c:if>
        <form
            action="meu-perfil"
            method="post"
            class="text-white bg-light-subtle p-3 rounded-3 needs-validation"
        >
          <h1 class="text-black text-center mb-4">Meu perfil</h1>
          <div class="d-flex mb-3">
            <input
                type="text"
                class="form-control"
                name="nome-novo"
                maxlength="30"
                value="${usuario.nome}"
                readonly
            />
            <input
                type="text"
                class="form-control ms-3"
                name="sobrenome-novo"
                maxlength="30"
                value="${usuario.sobrenome}"
                readonly
            />
          </div>
          <div class="mb-3">
            <input
                type="email"
                class="form-control"
                name="email-novo"
                maxlength="50"
                value="${usuario.email}"
                required
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">@</span>
            <input
                type="text"
                class="form-control"
                name="nome-usuario-novo"
                maxlength="20"
                value="${usuario.nomeUsuario}"
                required
            />
          </div>
          <div class="input-group mb-3">
            <input
                type="date"
                class="form-control"
                name="dt-nascimento-novo"
                value="${usuario.dataNascimento}"
                readonly
            />
            <div class="input-group-text ms-3">
              <input
                  class="form-check-input mt-0"
                  type="checkbox"
                  value="true"
                  name="novidades-novo"
                  ${info.enviarNovidades.toString() == "Y" ? "checked" : ""}
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
            <select class="form-select" name="pronomes-novo">
              <option disabled>Seus pronomes</option>
              <option value="Ele/Dele" ${info.pronomes == "Ele/Dele" ? "selected" : ""}>Ele/Dele</option>
              <option value="Ela/Dela" ${info.pronomes == "Ela/Dela" ? "selected" : ""}>Ela/dela</option>
              <option value="Outros" ${info.pronomes == "Outros" ? "selected" : ""}>Outros</option>
            </select>
            <input
                type="text"
                class="form-control ms-3"
                id="apelido-novo"
                name="apelido-novo"
                value="${info.apelido}"
                placeholder="Seu apelido"
            />
          </div>
          <div class="text-end">
            <button class="btn btn-success btn-lg ms-3">
              <b>Atualizar</b>
            </button>
          </div>
        </form>
      </div>
    </main>
    <script src="resources/js/validar.js"></script>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
