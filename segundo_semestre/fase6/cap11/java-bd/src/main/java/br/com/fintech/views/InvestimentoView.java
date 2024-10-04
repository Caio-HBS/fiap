package br.com.fintech.views;

import br.com.fintech.exception.ErroNaQueryException;
import br.com.fintech.exception.NaoFoiPossivelConectarException;
import br.com.fintech.model.Investimento;
import br.com.fintech.model.InvestimentoDAO;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class InvestimentoView {

    public static boolean testarInvestimentos() {
        try {
            // Inserindo novos investimentos no BD
            System.out.println("--- Adicionando investimentos ---");
            List<Investimento> novosInvs = new ArrayList<>();
            InvestimentoDAO dao = new InvestimentoDAO();

            novosInvs.add(new Investimento("Inv 1", "Primeiro investimento", Date.valueOf("2024-10-01"), 150.00F, 10));
            novosInvs.add(new Investimento("Inv 2", "Segundo investimento", Date.valueOf("2024-10-02"), 14000.00F, 20));
            novosInvs.add(new Investimento("Inv 3", "Terceiro investimento", Date.valueOf("2024-10-03"), 2500.00F, 30));
            novosInvs.add(new Investimento("Inv 4", "Quarto investimento", Date.valueOf("2024-10-04"), 10000.00F, 40));
            novosInvs.add(new Investimento("Inv 5", "Quinto investimento", Date.valueOf("2024-10-05"), 29.00F, 50));

            for (Investimento inv : novosInvs) {
                dao.insert(inv);
                System.out.println("BD: Investimento inserido.");
            }

            // Recuperando todos os investimentos cadastrados no BD
            List<Investimento> invRec = dao.getAll();
            dao.fecharConexao();

            // Checa se a query retornou resultados ou não
            if (invRec.isEmpty()) {
                return false;
            }
        } catch (NaoFoiPossivelConectarException | ErroNaQueryException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;

    }

}