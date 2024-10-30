package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.UsuarioInfoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.UsuarioInfo;

import java.sql.*;
import java.time.LocalDate;

public class OracleUsuarioInfoDAO implements UsuarioInfoDAO {

    private Connection conexao;

    @Override
    public void cadastrar(UsuarioInfo usuarioInfo) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "INSERT INTO t_usuario_info (id_usuario, dt_registro, email_verificado, enviar_novidades, " +
                    "pronomes, apelido) VALUES (?, ?, ?, ?, ?, ?)"
            );

            stmt.setInt(1, usuarioInfo.getIdUsuario());
            stmt.setDate(2, Date.valueOf(usuarioInfo.getDataRegistro()));
            stmt.setString(3, String.valueOf(usuarioInfo.getEmailVerificado()));
            stmt.setString(4, String.valueOf(usuarioInfo.getEnviarNovidades()));
            stmt.setString(5, String.valueOf(usuarioInfo.getPronomes()));
            stmt.setString(6, String.valueOf(usuarioInfo.getApelido()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar");
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
    public UsuarioInfo buscarPorIdUsuario(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioInfo info = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_usuario_info WHERE id_usuario = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                LocalDate dtRegistro = rs.getDate("dt_registro").toLocalDate();
                char emailVerificado = rs.getString("email_verificado").charAt(0);
                char enviarNovidades = rs.getString("enviar_novidades").charAt(0);
                String pronomes = rs.getString("pronomes");
                String apelido = rs.getString("apelido");

                info = new UsuarioInfo(idUsuario, dtRegistro, emailVerificado, enviarNovidades, pronomes, apelido);
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

        return info;

    }

    @Override
    public void atualizar(UsuarioInfo usuarioInfo) throws DBException {

        PreparedStatement stmt = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "UPDATE t_usuario_info SET email_verificado = ?, enviar_novidades = ?, pronomes = ?, " +
                    "apelido = ? WHERE id_usuario = ?"
            );
            stmt.setString(1, String.valueOf(usuarioInfo.getEmailVerificado()));
            stmt.setString(2, String.valueOf(usuarioInfo.getEnviarNovidades()));
            stmt.setString(3, usuarioInfo.getPronomes());
            stmt.setString(4, usuarioInfo.getApelido());
            stmt.setInt(5, usuarioInfo.getIdUsuario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar informação de usuário.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
