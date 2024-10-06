package br.com.fintech.model;

import br.com.fintech.exception.*;
import br.com.fintech.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoRecorrenteDAO {

    private Connection conexao;

    public ServicoRecorrenteDAO() {
        try {
            conexao = ConnectionFactory.getConnection();
        } catch (TabelaNaoEncontradaException | ValidacaoException | NaoFoiPossivelConectarException |
                 GenericaException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void insert(ServicoRecorrente sr) throws ErroNaQueryException {
        try {
            PreparedStatement stm = conexao.prepareStatement(
                    "INSERT INTO t_serv_recorrente (id_serv_recorrente, id_usuario, id_conta_bancaria, " +
                    "nm_servico, desc_servico, dt_registro_serv, dt_limite, frequencia, valor_operacao, " +
                    "operacao_efetuada, a_pagar, a_receber) VALUES (seq_serv_recorrente.nextval, 1, 2, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?)"
            );

            stm.setString(1, sr.getNmServico());
            stm.setString(2, sr.getDescServico());
            stm.setDate(3, sr.getDtRegistroServ());
            stm.setDate(4, sr.getDtLimite());
            stm.setString(5, sr.getFrequencia());
            stm.setDouble(6, sr.getValorOperacao());
            stm.setString(7, String.valueOf(sr.getOperacaoEfetuada()));
            stm.setString(8, String.valueOf(sr.getaPagar()));
            stm.setString(9, String.valueOf(sr.getaReceber()));

            stm.executeUpdate();


        } catch (SQLException e) {
            throw new ErroNaQueryException(e.getMessage());
        }
    }

    public List<ServicoRecorrente> getAll() throws ErroNaQueryException {
        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_serv_recorrente");
            ResultSet result = stm.executeQuery();

            List<ServicoRecorrente> lista = new ArrayList<>();
            while (result.next()) {
                Long idServRecorrente = result.getLong("id_serv_recorrente");
                Long idUsuario = result.getLong("id_usuario");
                Long idContaBancaria = result.getLong("id_conta_bancaria");
                String nmServico = result.getString("nm_servico");
                String descServico = result.getString("desc_servico");
                Date dtRegistroServ = result.getDate("dt_registro_serv");
                Date dtLimite = result.getDate("dt_limite");
                String frequencia = result.getString("frequencia");
                double valorOperacao = result.getDouble("valor_operacao");
                char operacaoEfetuada = result.getString("operacao_efetuada").charAt(0);
                char aPagar = result.getString("a_pagar").charAt(0);
                char aReceber = result.getString("a_receber").charAt(0);

                lista.add(
                        new ServicoRecorrente(idServRecorrente, idUsuario, idContaBancaria, nmServico, descServico,
                        dtRegistroServ, dtLimite, frequencia, valorOperacao, operacaoEfetuada, aPagar, aReceber)
                );
            }
            return lista;

        } catch (SQLException e) {
            throw new ErroNaQueryException(e.getMessage());
        }
    }

    public void fecharConexao() throws NaoFoiPossivelConectarException {
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new NaoFoiPossivelConectarException(e.getErrorCode());
        }
    }

}
