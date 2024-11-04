<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="pt_BR" />
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Not&iacute;cia</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="./resources/css/styles.css" />
    <link rel="shortcut icon" href="./resources/favicon.png" type="image/png" />
  </head>
  <body class="d-flex flex-column min-vh-100 index-cover">
    <c:choose>
      <c:when test="${not empty user}">
        <%@include file="includes/navbar.jsp" %>
      </c:when>
      <c:otherwise>
        <%@include file="includes/navbar-simple.jsp" %>
      </c:otherwise>
    </c:choose>
    <main class="container p-3 mt-5 bg-white rounded-2 shadow-lg">
      <h1 class="text-center">${noticia.titulo}</h1>
      <div class="d-flex justify-content-between">
        <fmt:parseDate
          value="${noticia.dataPublicacao}"
          pattern="yyyy-MM-dd"
          var="data"
        />
        <p>
          <fmt:formatDate value="${data}" pattern="dd 'de' MMMM 'de' yyyy" />
        </p>
        <p><b>${autor.nome} ${autor.sobrenome}</b></p>
      </div>
      <div class="justificar-texto">${noticia.texto}</div>
    </main>
    <footer class="footer mt-auto text-center text-white">
      <p><b>&copy; 2024. Todos os direitos reservados.</b></p>
    </footer>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
