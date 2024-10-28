package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.UsuarioInfoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.UsuarioInfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        return null;
    }

    @Override
    public void atualizar(UsuarioInfo usuarioInfo) throws DBException {

    }

}
