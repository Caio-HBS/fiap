package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.model.Investimento;

import java.util.List;

public interface InvestimentoDAO {

    void cadastrar(Investimento investimento) throws DBException;

    Investimento buscarPorId(int id);

    List<Investimento> listar(int usuarioId);

    void atualizar(Investimento investimento) throws DBException;

    void remover(int idInvestimento, int idUsuario) throws DBException;

}
