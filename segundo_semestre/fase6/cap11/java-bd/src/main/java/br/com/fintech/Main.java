package br.com.fintech;

import br.com.fintech.views.InvestimentoView;
import br.com.fintech.views.ServicoRecorrenteView;
import br.com.fintech.views.ServicoUnicoView;

public class Main {

    public static void main(String[] args) {

        // Testar investimentos
        boolean result_inv = InvestimentoView.testarInvestimentos();
        if (result_inv) {
            System.out.println("\nRESULTADO: Testes de investimentos bem-sucedidos!");
        } else {
            System.out.println("\nRESULTADO: Testes de investimento falharam.");
        }

        // Testar serviços únicos
        boolean result_su = ServicoUnicoView.testarServicosUnicos();
        if (result_su) {
            System.out.println("\nRESULTADO: Testes de serviços únicos bem-sucedidos!");
        } else {
            System.out.println("\nRESULTADO: Testes de serviços únicos falharam.");
        }

        // Testar serviços recorrentes
        boolean result_sr = ServicoRecorrenteView.testarServicosRecorrentes();
        if (result_sr) {
            System.out.println("\nRESULTADO: Testes de serviços recorrentes bem-sucedidos!");
        } else {
            System.out.println("\nRESULTADO: Testes de serviços recorrentes falharam.");
        }

    }

}