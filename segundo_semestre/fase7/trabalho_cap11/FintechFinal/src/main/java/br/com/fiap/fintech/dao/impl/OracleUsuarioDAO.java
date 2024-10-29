package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.UsuarioInfo;
import br.com.fiap.fintech.util.CriptografiaUtils;

import java.sql.*;

import java.time.LocalDate;
import java.util.Map;

public class OracleUsuarioDAO implements UsuarioDAO {

    private Connection conexao;

    @Override
    public void cadastrar(Usuario usuario) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "INSERT INTO t_usuario (id_usuario, nome, sobrenome, dt_nascimento, email, nm_usuario, senha, " +
                    "cargo) VALUES (seq_usuario.nextval, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getNomeUsuario());
            stmt.setString(6, usuario.getSenha());
            stmt.setString(7, usuario.getCargo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar usuário.");
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
    public Usuario buscarPorId(int id) {

        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "SELECT (id_usuario, nome, sobrenome, dt_nascimento, email, nm_usuario, cargo) from " +
                    "t_usuario WHERE id_usuario = ?"
            );
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = queryParaObjeto(rs);
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
        return usuario;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "SELECT id_usuario, nome, sobrenome, dt_nascimento, email, nm_usuario, cargo FROM " +
                    "t_usuario WHERE email = ?"
            );
            stmt.setString(1, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = queryParaObjeto(rs);
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
        return usuario;
    }

    @Override
    public Map<Usuario, UsuarioInfo> buscarCompletoPorId(int id) {

        Usuario usuario = null;
        UsuarioInfo usuarioInfo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

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

                usuarioInfo = new UsuarioInfo(
                        idUsuario, dtRegistro, emailVerificado, enviarNovidades, pronomes, apelido
                );
                usuario = buscarPorId(id);
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
        if (usuarioInfo != null && usuario != null) {
            return Map.of(usuario, usuarioInfo);
        }
        return Map.of();

    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement(
                    "UPDATE t_usuario SET nome = ?, sobrenome = ?, dt_nascimento = ?, email = ?, nm_usuario = ?, " +
                    "senha = ? WHERE id_usuario = ?"
            );

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getNomeUsuario());
            stmt.setString(6, usuario.getSenha());

            stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar usuário.");
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
    public void remover(int id) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("DELETE FROM t_usuario WHERE id_usuario = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover usuário.");
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
    public Usuario validarUsuario(String email, String senha) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, CriptografiaUtils.criptografar(senha));

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = queryParaObjeto(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

    private Usuario queryParaObjeto(ResultSet rs) throws SQLException {
        int idUsuario = rs.getInt("id_usuario");
        String nome = rs.getString("nome");
        String sobrenome = rs.getString("sobrenome");
        LocalDate dtNascimento = rs.getDate("dt_nascimento").toLocalDate();
        String nmUsuario = rs.getString("nm_usuario");
        String email = rs.getString("email");
        String cargo = rs.getString("cargo");

        return new Usuario(idUsuario, nome, sobrenome, dtNascimento, email, nmUsuario, "DUMMY", cargo);
    }

}
