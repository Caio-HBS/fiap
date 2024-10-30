<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Fintech | Not&iacute;cias</title>
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
    <main class="container p-3 mt-5 mt-lg-1">
      <h1 class="text-center text-white d-md-none"><b>NOT&Iacute;CIAS DA FINTECH</b></h1>
      <div id="carousselNoticias" class="carousel slide">
        <div class="carousel-indicators">
          <c:forEach items="${noticias}" varStatus="status">
            <button type="button" data-bs-target="#carousselNoticias" data-bs-slide-to="${status.index}"
              ${status.index == 0 ? "class='active'" : ""}></button>
          </c:forEach>
        </div>
        <div class="carousel-inner">
        <c:forEach items="${noticias}" var="noti" varStatus="status">
          <a href="${pageContext.request.contextPath}/noticia?id_noticia=${noti.idNoticia}"
             class="text-decoration-none text-white">
          <div class="carousel-item ${status.index == 0 ? "active" : ""}">
            <img src="./resources/images/noticias/${noti.imagem}" class="d-block w-100" alt="${noti.imagemAlt}">
            <div class="carousel-caption d-none d-md-block">
              <h5><b>${noti.titulo}</b></h5>
              <p><b>${noti.resumo}</b></p>
            </div>
          </div>
          </a>
        </c:forEach>
        <button class="carousel-control-prev" type="button" data-bs-target="#carousselNoticias" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Anterior</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carousselNoticias" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Pr&oacute;ximo</span>
        </button>
      </div>
      </div>
    </main>
    <footer class="footer mt-auto text-center text-white">
      <p><b>&copy; 2024. Todos os direitos reservados.</b></p>
    </footer>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
