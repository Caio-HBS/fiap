/**
 * Função utilizada para adicionar classes CSS à frequência.
 *
 * @param {string} tipo - O tipo de frequencia.
 */
function selecionarFrequencia(tipo) {
  document.getElementById("isolada").classList.remove("active");
  document.getElementById("recorrente").classList.remove("active");

  if (tipo === "isolada") {
    document.getElementById("isolada").classList.add("active");
  } else {
    document.getElementById("recorrente").classList.add("active");
  }
}

/**
 * Função utilizada para adicionar classes CSS à categoria.
 *
 * @param {string} tipo - O tipo de categoria.
 */
function selecionarCategoria(tipo) {
  document.getElementById("receber").classList.remove("active");
  document.getElementById("pagar").classList.remove("active");

  if (tipo === "receber") {
    document.getElementById("receber").classList.add("active");
  } else {
    document.getElementById("pagar").classList.add("active");
  }
}

/**
 * Função utilizada para formatar a data.
 *
 * @param {HTMLInputElement} input - O elemento HTML de input.
 */
function formatarData(input) {
  // Remove tudo que não é dígito
  let valor = input.value.replace(/\D/g, "");

  // Verifica se o valor está vazio para evitar processamento desnecessário
  if (valor.length === 0) {
    input.value = "";
    return;
  }

  // Define o formato do texto
  let formatado = "";

  if (valor.length > 2) {
    formatado += valor.substr(0, 2) + "/";
    valor = valor.substr(2);
  }
  if (valor.length > 2) {
    formatado += valor.substr(0, 2) + "/";
    valor = valor.substr(2);
  }
  formatado += valor; // Adiciona o ano, se disponível

  // Atualiza o valor do campo com o formato aplicado
  input.value = formatado;
}

/**
 * Função utilizada para formatar valores numéricos.
 *
 * @param {HTMLInputElement} input - O elemento HTML de input.
 */
function formatarValor(input) {
  // Remove todos os caracteres que não são dígitos
  let valor = input.value.replace(/\D/g, "");

  // Se o valor for vazio, apenas limpa o campo
  if (valor === "") {
    input.value = "";
    return;
  }

  // Adiciona a vírgula para separar os centavos
  let centavos = valor.slice(-2);
  let inteiro = valor.slice(0, -2);

  // Adiciona pontos como separadores de milhar
  let partes = [];
  while (inteiro.length > 3) {
    partes.unshift(inteiro.slice(-3));
    inteiro = inteiro.slice(0, -3);
  }
  partes.unshift(inteiro);

  // Cria a parte inteira formatada com separadores de milhar
  let inteiroFormatado = partes.join(".");

  // Atualiza o campo com o valor formatado
  input.value = "R$ " + inteiroFormatado + "," + (centavos || "00");
}

// Define o comportamento inicial
document.addEventListener("DOMContentLoaded", () => {
  const valorInput = document.getElementById("valor");

  valorInput.addEventListener("input", function () {
    formatarValor(this);
  });

  // Limpa o campo de valor ao carregar a página
  valorInput.value = "";
});
