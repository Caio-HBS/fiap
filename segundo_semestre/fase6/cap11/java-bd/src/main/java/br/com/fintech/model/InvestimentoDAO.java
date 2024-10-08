package br.com.fintech.model;

import br.com.fintech.exception.*;
import br.com.fintech.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {

    private Connection conexao;

    public InvestimentoDAO() {
        try {
            conexao = ConnectionFactory.getConnection();
        } catch (TabelaNaoEncontradaException | ValidacaoException | NaoFoiPossivelConectarException |
                 GenericaException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void insert(Investimento inv) throws ErroNaQueryException {
        try {
            // Uma vez que o enunciado dizia para não implementar um DAO para o usuário, o grupo decidiu que as queries
            // de inserção apontariam para um usuário criado previamente no banco de dados que possui id 1.
            PreparedStatement stm = conexao.prepareStatement(
                    "INSERT INTO t_investimento (id_usuario, id_investimento, nm_investimento, desc_investimento, " +
                    "dt_inicio, valor_inicial, percent_mensal) VALUES (1, seq_investimento.nextval, ?, ?, ?, ?, ?)"
            );

            stm.setString(1, inv.getNmInvestimento());
            stm.setString(2, inv.getDescInvestimento());
            stm.setDate(3, inv.getDtInicio());
            stm.setDouble(4, inv.getValorInicial());
            stm.setInt(5, inv.getPercentMensal());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new ErroNaQueryException(e.getLocalizedMessage());
        }
    }

    public List<Investimento> getAll() throws ErroNaQueryException {
        try {
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM t_investimento");
            ResultSet result = stm.executeQuery();

            List<Investimento> lista = new ArrayList<>();
            while (result.next()) {
                Long idInv = result.getLong("id_investimento");
                Long idUsuario = result.getLong("id_usuario");
                String inv = result.getString("nm_investimento");
                String descInv = result.getString("desc_investimento");
                Date data = result.getDate("dt_inicio");
                float valor = result.getFloat("valor_inicial");
                int percent = result.getInt("percent_mensal");

                lista.add(new Investimento(idInv, idUsuario, inv, descInv, data, valor, percent));
            }

            return lista;
        } catch (SQLException e) {
            throw new ErroNaQueryException(e.getLocalizedMessage());
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
