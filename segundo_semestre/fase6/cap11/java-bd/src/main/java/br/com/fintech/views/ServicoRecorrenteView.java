package br.com.fintech.views;

import br.com.fintech.exception.ErroNaQueryException;
import br.com.fintech.exception.NaoFoiPossivelConectarException;
import br.com.fintech.model.ServicoRecorrente;
import br.com.fintech.model.ServicoRecorrenteDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ServicoRecorrenteView {

    public static boolean testarServicosRecorrentes() {
        try {
            // Inserindo novos serviços recorrentes no BD
            System.out.println("\n--- Adicionando serviços recorrentes ---");
            List<ServicoRecorrente> novosSr = new ArrayList<>();
            ServicoRecorrenteDAO dao = new ServicoRecorrenteDAO();

            novosSr.add(
                    new ServicoRecorrente("Anuidade cartão", "Anuidade do cartão de crédito",
                            Date.valueOf("2024-05-05"), Date.valueOf("2024-12-31"), "anual", 15.00, 'Y', 'Y', 'N')
            );
            novosSr.add(
                    new ServicoRecorrente("Mensalidade Netflix", "Mensalidade da Netflix.", Date.valueOf("2021-02-09"),
                            Date.valueOf("2024-12-31"), "mensal", 30.00, 'Y', 'Y', 'N')
            );
            novosSr.add(
                    new ServicoRecorrente("Aluguel", "Aluguel da casa.", Date.valueOf("2024-05-05"), Date.valueOf("2024-12-31"),
                            "mensal", 1200.00, 'Y', 'Y', 'N')
            );
            novosSr.add(
                    new ServicoRecorrente("Internet", "Conta de internet.", Date.valueOf("2018-01-05"), Date.valueOf("2024-12-05"),
                            "mensal", 150.00, 'Y', 'Y', 'N')
            );
            novosSr.add(
                    new ServicoRecorrente("Limpeza", "Limpeza de casa", Date.valueOf("2023-05-24"), Date.valueOf("2024-12-05"),
                            "mensal", 200.00, 'Y', 'Y', 'N')
            );

            for (ServicoRecorrente sr : novosSr) {
                dao.insert(sr);
                System.out.println("BD: Serviço recorrente inserido.");
            }

            List<ServicoRecorrente> srRec = dao.getAll();
            dao.fecharConexao();

            if (srRec.isEmpty()) {
                return false;
            }

        } catch (NaoFoiPossivelConectarException | ErroNaQueryException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
