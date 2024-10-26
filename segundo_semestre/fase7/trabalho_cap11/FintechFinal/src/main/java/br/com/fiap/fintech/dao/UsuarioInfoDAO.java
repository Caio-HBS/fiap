package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.UsuarioInfo;

public interface UsuarioInfoDAO {

    void cadastrar(UsuarioInfo usuarioInfo) throws DBException;

    UsuarioInfo buscarPorIdUsuario(int usuarioId);

    void atualizar(UsuarioInfo usuarioInfo) throws DBException;

}
