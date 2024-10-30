<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Opera&ccedil;&atilde;o</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./resources/css/styles.css" />
    <link rel="shortcut icon" href="./resources/favicon.png" type="image/png" />
  </head>
  <body class="d-flex flex-column min-vh-100">
    <%@include file="includes/navbar.jsp" %>
    <div class="container">
      <div>
        <div>
          <div class="mt-5">
            <h1 class="h-5 text-center">Atualizar opera&ccedil;&atilde;o</h1>
          </div>
          <form class="text-end mt-2" action="operacao?id=${op.idOperacao}&acao=deletar" method="post">
            <button class="btn btn-danger">
              Deletar opera&ccedil;&atilde;o
            </button>
          </form>
          <c:if test="${not empty erro}">
            <p class="text-danger text-center"><b>${erro}</b></p>
          </c:if>
          <div class="modal-body">
            <form class="d-flex flex-column" action="operacao?id=${op.idOperacao}&acao=atualizar" method="post">
              <label for="nome-operacao"
                ><b>Nome da opera&ccedil;&atilde;o</b></label
              >
              <input
                type="text"
                class="form-control"
                id="nome-operacao"
                name="nome-operacao"
                maxlength="30"
                value="${op.nomeOperacao}"
                required
              />
              <label for="desc-operacao" class="mt-2"
                ><b>Descri&ccedil;&atilde;o da opera&ccedil;&atilde;o</b></label
              >
              <input
                type="text"
                class="form-control"
                id="desc-operacao"
                name="desc-operacao"
                maxlength="100"
                value="${op.descricaoOperacao}"
                required
              />
              <label for="tipo-operacao" class="mt-2"
                ><b>Tipo de opera&ccedil;&atilde;o</b></label
              >
              <select
                class="form-select"
                name="tipo-operacao"
                id="tipo-operacao"
              >
                <option disabled>
                  Selecionar tipo de opera&ccedil;&atilde;o
                </option>
                <option value="D" ${op.tipoOperacao.toString() == 'D' ? "selected" : ""}>Despesa (gasto)</option>
                <option value="R" ${op.tipoOperacao.toString() == 'R' ? "selected" : ""}>Receita (ganho)</option>
              </select>
              <label for="data-operacao" class="mt-2"
                ><b>Data da opera&ccedil;&atilde;o</b></label
              >
              <input
                type="date"
                class="form-control"
                name="data-operacao"
                id="data-operacao"
                value="${op.dataOperacao}"
                required
              />
              <label for="valor-operacao" class="mt-2"><b>Valor</b></label>
              <input
                type="number"
                class="form-control"
                id="valor-operacao"
                name="valor-operacao"
                value="${op.valorOperacao}"
                required
              />

              <div class="mt-2 text-end">
                <a href="operacoes" class="btn btn-warning">Cancelar</a>
                <button class="btn btn-success ms-2">Atualizar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <%@include file="includes/footer.jsp" %>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
