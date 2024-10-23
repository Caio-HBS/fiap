package br.com.fiap.estudodecaso.dao;

import br.com.fiap.estudodecaso.exception.DBException;
import br.com.fiap.estudodecaso.model.Produto;

import java.util.List;

public interface ProdutoDAO {

    void cadastrar(Produto produto) throws DBException;

    Produto buscar(int id);

    List<Produto> listar();

    void atualizar(Produto produto) throws DBException;

    void remover(int codigo) throws DBException;

}