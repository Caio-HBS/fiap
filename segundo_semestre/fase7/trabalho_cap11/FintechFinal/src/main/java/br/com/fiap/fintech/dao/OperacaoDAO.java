package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Operacao;

import java.util.List;

public interface OperacaoDAO {

    void cadastrar(Operacao operacao) throws DBException;

    Operacao buscarPorId(int id);

    List<Operacao> listar(int usuarioId);

    void atualizar(Operacao operacao) throws DBException;

    void remover(int idOperacao, int idUsuario) throws DBException;

}
