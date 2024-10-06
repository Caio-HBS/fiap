package br.com.fintech.model;

import br.com.fintech.exception.*;
import br.com.fintech.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoUnicoDAO {

    private Connection conexao;

    public ServicoUnicoDAO() {
        try {
            conexao = ConnectionFactory.getConnection();
        } catch (TabelaNaoEncontradaException | ValidacaoException | NaoFoiPossivelConectarException |
                 GenericaException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void insert(ServicoUnico su) throws ErroNaQueryException {
        try {
            // Uma vez que o enunciado dizia para não implementar um DAO para o usuário, o grupo decidiu que as queries
            // de inserção apontariam para um usuário criado previamente no banco de dados que possui id 1.
            PreparedStatement stm = conexao.prepareStatement(
                    "INSERT INTO t_serv_unico (id_serv_unico, id_usuario, id_conta_bancaria, nm_servico, " +
                    "desc_servico, dt_registro_serv, dt_operacao, valor_operacao, a_pagar, a_receber) VALUES (" +
                    "seq_serv_unico.nextval, 1, 2, ?, ?, ?, ?, ?, ?, ?)"
            );

            stm.setString(1, su.getNmServico());
            stm.setString(2, su.getDescServico());
            stm.setDate(3, su.getDtRegistroServ());
            stm.setDate(4, su.getDtOperacao());
            stm.setDouble(5, su.getValorOperacao());
            stm.setString(6, String.valueOf(su.getaPagar()));
            stm.setString(7, String.valueOf(su.getaReceber()));

            stm.executeUpdate();

        } catch (SQLException e) {
            throw new ErroNaQueryException(e.getMessage());
        }
    }

    public List<ServicoUnico> getAll() throws ErroNaQueryException {
        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_serv_unico");
            ResultSet result = stm.executeQuery();

            List<ServicoUnico> lista = new ArrayList<>();
            while (result.next()) {
                Long idServUnico = result.getLong("id_serv_unico");
                Long idUsuario = result.getLong("id_usuario");
                Long idContaBancaria = result.getLong("id_conta_bancaria");
                String nmServico = result.getString("nm_servico");
                String descServico = result.getString("desc_servico");
                Date dtRegistroServ = result.getDate("dt_registro_serv");
                Date dtOperacao = result.getDate("dt_operacao");
                double valorOperacao = result.getDouble("valor_operacao");
                char aPagar = result.getString("a_pagar").toUpperCase().charAt(0);
                char aReceber = result.getString("a_receber").toUpperCase().charAt(0);

                lista.add(
                        new ServicoUnico(idServUnico, idUsuario, idContaBancaria, nmServico, descServico,
                                dtRegistroServ, dtOperacao, valorOperacao, aPagar, aReceber)
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
