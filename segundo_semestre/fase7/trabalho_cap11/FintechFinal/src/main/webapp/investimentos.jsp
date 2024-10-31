<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Investimentos</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./resources/css/styles.css" />
    <link rel="shortcut icon" href="./resources/favicon.png" type="image/png" />
  </head>
  <body class="d-flex flex-column min-vh-100">
    <div class="modal fade" id="novoInvestimento" tabindex="-1" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="novoInvestimentolLabel">
              Adicionar investimento
            </h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <form method="post" action="investimentos" class="d-flex flex-column">
              <label for="nome-investimento"
                ><b>Nome do investimento</b></label
              >
              <input
                type="text"
                class="form-control"
                id="nome-investimento"
                name="nome-investimento"
                maxlength="30"
                placeholder='Ex: "A&ccedil;&otilde;es"'
                required
              />
              <label for="desc-investimento" class="mt-2"
                ><b>Descri&ccedil;ão do investimento</b></label
              >
              <textarea
                type="text"
                class="form-control"
                id="desc-investimento"
                name="desc-investimento"
                maxlength="100"
                placeholder='Ex: "A&ccedil;&otilde;es da Petrobras"'
                required
              ></textarea>
              <label for="data-inicio-investimento" class="mt-2"
                ><b>Início do investimento</b></label
              >
              <input
                type="date"
                class="form-control"
                name="data-inicio-investimento"
                id="data-inicio-investimento"
                required
              />
              <label for="valor-investimento" class="mt-2"><b>Valor inicial</b></label>
              <input
                type="number"
                class="form-control"
                id="valor-investimento"
                name="valor-investimento"
                placeholder="Ex: R$20,00"
                required
              />
              <label for="percent-mensal" class="mt-2"><b>Percentual mensal</b></label>
              <input
                type="number"
                class="form-control"
                id="percent-mensal"
                name="percent-mensal"
                placeholder="1"
                min="1"
                max="100"
                required
              />
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-danger"
              data-bs-dismiss="modal"
            >
              Cancelar
            </button>
            <button class="btn btn-success">Adicionar</button>
          </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <%@include file="includes/navbar.jsp" %>
    <main class="container">
      <div class="my-3">
        <h1 class="mb-0"><b>Meus investimentos</b></h1>
      </div>
      <div class="d-flex justify-content-between align-items-center">
        <div>
          <div class="d-flex">
            <button class="btn btn-secondary" disabled>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-search"
                viewBox="0 0 16 16"
              >
                <path
                  d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
              </svg>
            </button>
            <input
              class="ms-0 input-group-text"
              type="text"
              placeholder="Buscar"
            />
          </div>
        </div>
        <button
          class="btn btn-info text-white"
          data-bs-toggle="modal"
          data-bs-target="#novoInvestimento"
        >
          <b>Adicionar</b>
        </button>
      </div>
      <c:choose>
        <c:when test="${not empty investimentos}">
          <table class="table table-hover table-striped mt-3 text-center">
            <thead class="h4">
              <tr>
                <th class="d-none d-lg-table-cell">ID</th>
                <th>NOME</th>
                <th>VALOR INICIAL</th>
                <th class="d-none d-lg-table-cell">DATA IN&Iacute;CIO</th>
                <th class="d-none d-lg-table-cell">PERCENTUAL (MENSAL)</th>
                <th>EDITAR</th>
              </tr>
            </thead>
            <tbody class="lead">
              <c:forEach items="${investimentos}" var="inv">
                <tr>
                  <td class="d-none d-lg-table-cell">${inv.idInvestimento}</td>
                  <td>${fn:length(inv.nomeInvestimento) > 10 ? fn:substring(inv.nomeInvestimento, 0, 10) : inv.nomeInvestimento}</td>
                  <td><fmt:formatNumber
                      value="${inv.valorInicial}"
                      type="currency"
                      currencySymbol="R$"
                      groupingUsed="true"
                      maxFractionDigits="2"
                      minFractionDigits="2"
                  /></td>
                  <fmt:parseDate value="${inv.dataInicio.toString()}" pattern="yyyy-MM-dd" var="dataFormatada" />
                  <td class="d-none d-lg-table-cell"><fmt:formatDate value="${dataFormatada}" pattern="dd/MM/yyyy" /></td>
                  <td class="d-none d-lg-table-cell">${inv.percentMensal}%</td>
                  <td>
                    <a href="investimento?id=${inv.idInvestimento}" class="text-decoration-none text-black">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="20"
                        height="20"
                        fill="currentColor"
                        class="bi bi-info-circle-fill"
                        viewBox="0 0 16 16"
                    >
                      <path
                          d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16m.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2"></path>
                    </svg>
                    </a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:when>
        <c:otherwise>
          <p class="h1 text-center pt-5">Voc&ecirc; ainda n&atilde;o tem nenhum investimento cadastrado</p>
        </c:otherwise>
      </c:choose>
    </main>
    <%@include file="includes/footer.jsp" %>
    <script src="resources/js/buscar.js"></script>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
