package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Investimento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleInvestimentoDAO implements InvestimentoDAO {

    private Connection conexao;

    @Override
    public void cadastrar(Investimento investimento) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "INSERT INTO t_investimento (id_investimento, id_usuario, nm_investimento, desc_investimento, " +
                    "dt_inicio, valor_inicial, percent_mensal) VALUES (seq_investimento.nextval, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setInt(1, investimento.getIdUsuario());
            stmt.setString(2, investimento.getNomeInvestimento());
            stmt.setString(3, investimento.getDescricaoInvestimento());
            stmt.setDate(4, Date.valueOf(investimento.getDataInicio()));
            stmt.setDouble(5, investimento.getValorInicial());
            stmt.setInt(6, investimento.getPercentMensal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar investimento");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Investimento buscarPorId(int id) {

        Investimento investimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_investimento WHERE id_investimento = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                investimento = queryParaObjeto(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimento;

    }

    @Override
    public List<Investimento> listar(int usuarioId) {

        List<Investimento> investimentos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "SELECT * FROM t_investimento WHERE id_usuario = ? ORDER BY dt_inicio DESC"
            );
            stmt.setInt(1, usuarioId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                investimentos.add(queryParaObjeto(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimentos;

    }

    @Override
    public void atualizar(Investimento investimentoAtualizado) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "UPDATE t_investimento SET nm_investimento = ?, desc_investimento = ?, dt_inicio = ?, " +
                    "valor_inicial = ?, percent_mensal = ? WHERE id_investimento = ? AND id_usuario = ?"
            );
            stmt.setString(1, investimentoAtualizado.getNomeInvestimento());
            stmt.setString(2, investimentoAtualizado.getDescricaoInvestimento());
            stmt.setDate(3, Date.valueOf(investimentoAtualizado.getDataInicio()));
            stmt.setDouble(4, investimentoAtualizado.getValorInicial());
            stmt.setInt(5, investimentoAtualizado.getPercentMensal());
            stmt.setInt(6, investimentoAtualizado.getIdInvestimento());
            stmt.setInt(7, investimentoAtualizado.getIdUsuario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar investimento");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void remover(int idInvestimento, int idUsuario) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "DELETE FROM t_investimento WHERE id_investimento = ? and id_usuario = ?"
            );
            stmt.setInt(1, idInvestimento);
            stmt.setInt(2, idUsuario);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover investimento");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private Investimento queryParaObjeto(ResultSet rs) throws SQLException {

        LocalDate dtTermino;

        int idInvestimento = rs.getInt("id_investimento");
        int idUsuario = rs.getInt("id_usuario");
        String nmInvestimento = rs.getString("nm_investimento");
        String descInvestimento = rs.getString("desc_investimento");
        LocalDate dtInicio = rs.getDate("dt_inicio").toLocalDate();
        try {
            dtTermino = rs.getDate("dt_termino").toLocalDate();
        } catch (NullPointerException e) {
            dtTermino = null;
        }
        double valorInicial = rs.getDouble("valor_inicial");
        int percentMensal = rs.getInt("percent_mensal");

        return new Investimento(
                idInvestimento, idUsuario, nmInvestimento, descInvestimento,
                dtInicio, dtTermino, valorInicial, percentMensal
        );

    }

}
