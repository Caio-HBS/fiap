package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.UsuarioInfo;

import java.util.Map;


public interface UsuarioDAO {

    void cadastrar(Usuario usuario) throws DBException;

    Usuario buscarPorId(int id);

    Map<Usuario, UsuarioInfo> buscarCompletoPorId(int id);

    void atualizar(Usuario usuario) throws DBException;

    void remover(int id) throws DBException;

}
