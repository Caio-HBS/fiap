package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.OperacaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Operacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleOperacaoDAO implements OperacaoDAO {

    private Connection conexao;

    @Override
    public void cadastrar(Operacao operacao) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "INSERT INTO t_operacao (id_operacao, id_usuario, nm_operacao, desc_operacao, tipo_operacao, " +
                    "dt_registro, dt_operacao, valor) VALUES (seq_operacao.nextval, ?, ?, ?, ?, ?, ?, ?)"
            );

            stmt.setInt(1, operacao.getIdUsuario());
            stmt.setString(2, operacao.getNomeOperacao());
            stmt.setString(3, operacao.getDescricaoOperacao());
            stmt.setString(4, String.valueOf(operacao.getTipoOperacao()));
            stmt.setDate(5, Date.valueOf(operacao.getDataRegistro()));
            stmt.setDate(6, Date.valueOf(operacao.getDataOperacao()));
            stmt.setDouble(7, operacao.getValorOperacao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar operação");
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
    public Operacao buscarPorId(int id) {
        PreparedStatement stmt = null;
        Operacao operacao = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_operacao WHERE id_operacao = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                operacao = queryParaObjeto(rs);
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
        return operacao;
    }

    @Override
    public List<Operacao> listar(int usuarioId) {

        List<Operacao> operacoes = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_operacao WHERE id_usuario = ? ORDER BY dt_operacao DESC");
            stmt.setInt(1, usuarioId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                operacoes.add(queryParaObjeto(rs));
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
        return operacoes;

    }

    @Override
    public void atualizar(Operacao operacaoAtualizada) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "UPDATE t_operacao SET nm_operacao = ?, desc_operacao = ?, tipo_operacao = ?, " +
                    "dt_registro = ?, dt_operacao = ?, valor = ? WHERE id_operacao = ? AND id_usuario = ?"
            );

            stmt.setString(1, operacaoAtualizada.getNomeOperacao());
            stmt.setString(2, operacaoAtualizada.getDescricaoOperacao());
            stmt.setString(3, String.valueOf(operacaoAtualizada.getTipoOperacao()));
            stmt.setDate(4, Date.valueOf(operacaoAtualizada.getDataRegistro()));
            stmt.setDate(5, Date.valueOf(operacaoAtualizada.getDataOperacao()));
            stmt.setDouble(6, operacaoAtualizada.getValorOperacao());
            stmt.setInt(7, operacaoAtualizada.getIdOperacao());
            stmt.setInt(8, operacaoAtualizada.getIdUsuario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar operação.");
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
    public void remover(int idOperacao, int idUsuario) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("DELETE FROM t_operacao WHERE id_operacao = ? AND id_usuario = ?");
            stmt.setInt(1, idOperacao);
            stmt.setInt(2, idUsuario);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover operação");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private Operacao queryParaObjeto(ResultSet rs) throws SQLException {
        int idOperacao = rs.getInt("id_operacao");
        int idUsuario = rs.getInt("id_usuario");
        String nmOperacao = rs.getString("nm_operacao");
        String descOperacao = rs.getString("desc_operacao");
        char tipoOperacao = rs.getString("tipo_operacao").charAt(0);
        LocalDate dtRegistro = rs.getDate("dt_registro").toLocalDate();
        LocalDate dtOperacao = rs.getDate("dt_operacao").toLocalDate();
        double valorOperacao = rs.getDouble("valor");

        return new Operacao(
                idOperacao, idUsuario, nmOperacao, descOperacao, dtRegistro, dtOperacao, valorOperacao, tipoOperacao
        );
    }

}
