<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Investimento</title>
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
            <h1 class="h-5 text-center">Atualizar investimento</h1>
          </div>
          <form class="text-end mt-2" action="investimento?id=${inv.idInvestimento}&acao=deletar" method="post">
            <button class="btn btn-danger">
              Deletar investimento
            </button>
          </form>
          <c:if test="${not empty erro}">
            <p class="text-danger text-center"><b>${erro}</b></p>
          </c:if>
          <div class="modal-body">
            <form class="d-flex flex-column" action="investimento?id=${inv.idInvestimento}&acao=atualizar" method="post">
              <label for="nome-investimento">
                <b>Nome do investimento</b>
              </label>
              <input
                type="text"
                class="form-control"
                id="nome-investimento"
                name="nome-investimento"
                maxlength="30"
                value="${inv.nomeInvestimento}"
                required
              />
              <label for="desc-investimento" class="mt-2"
                ><b>Descri&ccedil;&atilde;o do investimento</b></label
              >
              <input
                type="text"
                class="form-control"
                id="desc-investimento"
                name="desc-investimento"
                maxlength="100"
                value="${inv.descricaoInvestimento}"
                required
              />
              <label for="data-inicio-investimento" class="mt-2"
                ><b>In&iacute;cio do investimento</b></label
              >
              <input
                type="date"
                class="form-control"
                name="data-inicio-investimento"
                id="data-inicio-investimento"
                value="${inv.dataInicio}"
                required
              />
              <label for="data-termino-investimento" class="mt-2"
                ><b>Fim do investimento</b></label
              >
              <input
                type="date"
                class="form-control"
                name="data-termino-investimento"
                id="data-termino-investimento"
                value="${inv.dataTermino}"
              />
              <label for="valor-investimento" class="mt-2"><b>Valor inicial</b></label>
              <input
                type="number"
                class="form-control"
                id="valor-investimento"
                name="valor-investimento"
                value="${inv.valorInicial}"
                required
              />
              <label for="percent-mensal" class="mt-2"><b>Percentual mensal</b></label>
              <input
                type="number"
                class="form-control"
                id="percent-mensal"
                name="percent-mensal"
                value="${inv.percentMensal}"
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
