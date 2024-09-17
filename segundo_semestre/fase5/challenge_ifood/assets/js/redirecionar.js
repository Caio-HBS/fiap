/**
 * Função utilizada para redirecionar usuário.
 *
 * Essa função replica o comportamento de um aplicativo convencional
 * redirecionando o usuário no envio do formulário de login ou de registro.
 *
 * @param {string} formId - O ID do formulário.
 */
function redirecionar(formId) {
  if (formId === "registro-form") {
    window.location.href = "dashboard.html";
  } else if (formId === "login-form") {
    window.location.href = "pages/dashboard.html";
  }
}

form = document.getElementById("registro-form");

if (form) {
  form.addEventListener("submit", function (event) {
    event.preventDefault();
    redirecionar(this.id);
  });
} else {
  form = document.getElementById("login-form");

  form.addEventListener("submit", function (event) {
    event.preventDefault();
    redirecionar(this.id);
  });
}
