package br.com.fintech;

import br.com.fintech.exception.*;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.ServicoUnico;
import br.com.fintech.model.ServicoUnicoDAO;
import br.com.fintech.views.InvestimentoView;
import br.com.fintech.views.ServicoUnicoView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Testar investimentos
        //boolean result_inv = InvestimentoView.testarInvestimentos();
        //if (result_inv) {
        //    System.out.println("\nRESULTADO: Testes de investimentos bem-sucedidos!");
        //} else {
        //    System.out.println("\nRESULTADO: Testes de investimento falharam.");
        //}

        // Testar serviços únicos
        boolean result_su = ServicoUnicoView.testarServicosUnicos();
        if (result_su) {
            System.out.println("\nRESULTADO: Testes de serviços únicos bem-sucedidos!");
        } else {
            System.out.println("\nRESULTADO: Testes de serviços únicos falharam.");
        }

    }

}