package br.com.fintech.views;

import br.com.fintech.exception.ErroNaQueryException;
import br.com.fintech.exception.NaoFoiPossivelConectarException;
import br.com.fintech.model.ServicoUnico;
import br.com.fintech.model.ServicoUnicoDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ServicoUnicoView {

    public static boolean testarServicosUnicos() {
        try {
            // Inserindo novos serviços únicos no BD
            System.out.println("\n--- Adicionando serviços únicos ---");
            List<ServicoUnico> novosSu = new ArrayList<>();
            ServicoUnicoDAO dao = new ServicoUnicoDAO();

            novosSu.add(
                    new ServicoUnico("Jantar", "Jantar no restaurante.", Date.valueOf("2024-10-10"), Date.valueOf("2024-10-10"), 217.72, 'Y', 'N')
            );
            novosSu.add(
                    new ServicoUnico("Spotify", "Mensalidade Spotify", Date.valueOf("2024-10-11"), Date.valueOf("2024-10-11"), 20.00, 'Y', 'N')
            );
            novosSu.add(new ServicoUnico("Jantar", "Jantar no restaurante.", Date.valueOf("2024-10-12"), Date.valueOf("2024-10-12"), 178.96, 'Y', 'N')
            );
            novosSu.add(
                    new ServicoUnico("Conta luz", "Conta de luz.", Date.valueOf("2024-10-13"), Date.valueOf("2024" + "-10-13"), 90.15, 'Y', 'N')
            );
            novosSu.add(
                    new ServicoUnico("Conta água", "Conta de água.", Date.valueOf("2024-10-14"), Date.valueOf("2024-10-14"), 82.11, 'Y', 'N')
            );

            for (ServicoUnico su : novosSu) {
                dao.insert(su);
                System.out.println("BD: Serviço único inserido.");
            }

            // Recuperando todos os serviços únicos cadastrados no BD
            List<ServicoUnico> suRec = dao.getAll();
            dao.fecharConexao();

            // Checa se a query retornou resultados ou não
            if (suRec.isEmpty()) {
                return false;
            }
        } catch (NaoFoiPossivelConectarException | ErroNaQueryException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

}
