document.addEventListener("DOMContentLoaded", function () {
  const searchInput = document.querySelector('input[placeholder="Buscar"]');
  const tableRows = document.querySelectorAll("table tbody tr");

  searchInput.addEventListener("input", function () {
    const searchTerm = searchInput.value.toLowerCase();

    // Baseado no que foi escrito no input e nas informações de cada linha,
    // as mostra ou as esconde da tabela.
    tableRows.forEach((row) => {
      const rowText = row.textContent.toLowerCase();
      if (rowText.includes(searchTerm)) {
        row.style.display = "";
      } else {
        row.style.display = "none";
      }
    });
  });
});
