const INFO_MODAL = {
  0 : {
    "nome": "Venda iFood",
    "descricao": "Venda feita pelo app iFood de ID: 11865.",
    "valor": "R$78,98",
    "categoria": "A receber",
    "data": "01/09/2024"
  },
  1 : {
    "nome": "Venda iFood",
    "descricao": "Venda feita pelo app iFood de ID: 12005.",
    "valor": "R$52,20",
    "categoria": "A receber",
    "data": "01/09/2024"
  },
  2 : {
    "nome": "Venda iFood",
    "descricao": "Venda feita pelo app iFood de ID: 15025.",
    "valor": "R$103,98",
    "categoria": "A receber",
    "data": "01/09/2024"
  },
  3 : {
    "nome": "Pagamento motoboy",
    "descricao": "Salário mensal de funcionários.",
    "valor": "R$1.478,92",
    "categoria": "A pagar",
    "data": "05/09/2024"
  },
  4 : {
    "nome": "Pagamento cozinheiros",
    "descricao": "Salário mensal de funcionários.",
    "valor": "R$2.210,92",
    "categoria": "A pagar",
    "data": "05/09/2024"
  },
  5 : {
    "nome": "Fornecedor carnes",
    "descricao": "Pagamento ao fornecedor: açougue Império das Carnes.",
    "valor": "R$2.450,00",
    "categoria": "A pagar",
    "data": "05/09/2024"
  },
  6 : {
    "nome": "Venda iFood",
    "descricao": "Venda feita pelo app iFood de ID: 12885.",
    "valor": "R$35,94",
    "categoria": "A receber",
    "data": "07/09/2024"
  },
  7 : {
    "nome": "Feira",
    "descricao": "Pagamento ao fornecedor: feira de rua.",
    "valor": "R$780,31",
    "categoria": "A pagar",
    "data": "07/09/2024"
  },
  8 : {
    "nome": "Conta luz",
    "descricao": "Pagamento mensal à companhia de energia",
    "valor": "R$550,96",
    "categoria": "A pagar",
    "data": "07/09/2024"
  },
  9 : {
    "nome": "Conta água",
    "descricao": "Pagamento mensal à companhia de saneamento.",
    "valor": "R$679,31",
    "categoria": "A pagar",
    "data": "07/09/2024"
  },
}

/**
 * Função utilizada para popular modal.
 *
 * @param {number} indice - O índice da constante de informações para o modal.
 */
function popularModal(indice) {
  const infoModal = INFO_MODAL[indice];

  const modNome = document.getElementById("modal-nome");
  modNome.innerText = infoModal.nome

  const modDesc = document.getElementById("modal-desc");
  modDesc.innerText = infoModal.descricao

  const modValor = document.getElementById("modal-valor");
  modValor.innerText = infoModal.valor

  const modCat = document.getElementById("modal-cat");
  modCat.innerText = infoModal.categoria

  const modData = document.getElementById("modal-data");
  modData.innerText = infoModal.data
}


/**
 * Função que ordena uma tabela HTML com base na coluna clicada.
 *
 * @param {number} indice - O índice da coluna a ser ordenada (começando em 0).
 */
function ordenarTabela(indice) {
  var tabela,
    linhas,
    trocando,
    i,
    x,
    y,
    deveTrocar,
    direcao,
    contadorTroca = 0;

  tabela = document.getElementById("tabela-transacoes");

  trocando = true;

  direcao = "asc";

  while (trocando) {
    trocando = false;

    linhas = tabela.rows;

    for (i = 1; i < linhas.length - 1; i++) {
      deveTrocar = false;
      x = linhas[i].getElementsByTagName("TD")[indice];
      y = linhas[i + 1].getElementsByTagName("TD")[indice];

      if (indice === 3) {
        var conteudoX = parseFloat(
          x.innerHTML.replace("R$", "").replace(",", ".")
        );
        var conteudoY = parseFloat(
          y.innerHTML.replace("R$", "").replace(",", ".")
        );
      } else {
        var conteudoX = x.innerHTML.toLowerCase();
        var conteudoY = y.innerHTML.toLowerCase();
      }

      if (direcao == "asc") {
        if (conteudoX > conteudoY) {
          deveTrocar = true;
          break;
        }
      } else if (direcao == "desc") {
        if (conteudoX < conteudoY) {
          deveTrocar = true;
          break;
        }
      }
    }

    if (deveTrocar) {
      linhas[i].parentNode.insertBefore(linhas[i + 1], linhas[i]);
      trocando = true;
      contadorTroca++;
    } else {
      if (contadorTroca == 0 && direcao == "asc") {
        direcao = "desc";
        trocando = true;
      }
    }
  }
}
