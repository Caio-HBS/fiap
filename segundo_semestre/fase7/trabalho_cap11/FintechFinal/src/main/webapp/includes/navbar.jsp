<nav class="navbar navbar-expand-lg bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="../index.jsp">Fintech</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <svg
          xmlns="http://www.w3.org/2000/svg"
          width="20"
          height="20"
          fill="white"
          class="bi bi-list"
          viewBox="0 0 16 16"
      >
        <path
            fill-rule="evenodd"
            d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5m0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5"
        ></path>
      </svg>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link text-white" aria-current="page" href="../noticias.jsp">Not&iacute;cias</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="../investimentos.jsp">Investimentos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="../operacoes.jsp">Opera&ccedil;&otilde;es</a>
        </li>
      </ul>
      <c:if test="${not empty user}">
        <form class="d-flex" action="login" method="get">
          <button class="btn btn-danger" type="submit">Logout</button>
        </form>
      </c:if>
    </div>
  </div>
</nav>