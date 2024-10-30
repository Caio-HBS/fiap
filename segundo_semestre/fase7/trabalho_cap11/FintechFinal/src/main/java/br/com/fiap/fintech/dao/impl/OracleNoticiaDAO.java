package br.com.fiap.fintech.dao.impl;

import br.com.fiap.fintech.dao.ConnectionManager;
import br.com.fiap.fintech.dao.NoticiaDAO;
import br.com.fiap.fintech.model.Noticia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleNoticiaDAO implements NoticiaDAO {

    private Connection conexao;

    @Override
    public Noticia buscarPorId(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Noticia noticia = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_noticia WHERE id_noticia = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                noticia = queryParaObjeto(rs);
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
        return noticia;

    }

    @Override
    public List<Noticia> listar() {

        PreparedStatement stmt = null;
        List<Noticia> noticias = new ArrayList<>();
        ResultSet rs = null;

        try {

            conexao = ConnectionManager.getInstance().getConnection();

            stmt = conexao.prepareStatement("SELECT * FROM t_noticia");

            rs = stmt.executeQuery();

            while (rs.next()) {
                noticias.add(queryParaObjeto(rs));
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
        return noticias;

    }

    private Noticia queryParaObjeto(ResultSet rs) throws SQLException {

        int idNoticia = rs.getInt("id_noticia");
        int idUsuario = rs.getInt("id_usuario");
        LocalDate dtPublicacao = rs.getDate("dt_publicacao").toLocalDate();
        String titulo = rs.getString("titulo");
        Clob textoClob = rs.getClob("texto");
        String texto = textoClob.getSubString(1, (int) textoClob.length());
        String resumo = rs.getString("resumo");
        String imagem = rs.getString("imagem");
        String imagemAlt = rs.getString("imagem_alt");

        return new Noticia(idNoticia, idUsuario, dtPublicacao, titulo, texto, resumo, imagem, imagemAlt);

    }

}
