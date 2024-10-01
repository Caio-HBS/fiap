package br.com.fintech;

import br.com.fintech.exception.TabelaNaoEncontradaException;
import br.com.fintech.views.InvestimentoView;

public class Main {

    public static void main(String[] args) throws TabelaNaoEncontradaException {

        // Testar investimentos
        boolean result_inv = InvestimentoView.testarInvestimentos();
        if (result_inv) {
            System.out.println("\nRESULTADO: Testes de investimentos bem-sucedidos!");
        } else {
            System.out.println("\nRESULTADO: Testes de investimento falharam.");
        }

    }

}