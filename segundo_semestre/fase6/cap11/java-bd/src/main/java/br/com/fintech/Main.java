package br.com.fintech;

import br.com.fintech.exception.RecursoNaoEncontradoException;
import br.com.fintech.model.Usuario;
import br.com.fintech.model.UsuarioDAO;

import java.sql.SQLException;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        //String dateString = "1994-08-25";

        //Date date = Date.valueOf(dateString);

        //try {
        //    UsuarioDAO dao = new UsuarioDAO();
        //    Usuario usuario = new Usuario("João", "Dias", date, "joao@email.com", "joao-dias", "senha" +
        //
        //                                                                                                    "-segura");
        //    dao.cadastrarUsuario(usuario);
        //    dao.fecharConexao();
        //    System.out.println("Usuário cadastrado!");
        //} catch (SQLException e) {
        //    System.err.println(e.getMessage());
        //}

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.pesquisarUsuario(16L);
            System.out.println(usuario);
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (RecursoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

}