package br.com.fiap.estudodecaso.dao.impl;

import br.com.fiap.estudodecaso.dao.ProdutoDAO;
import br.com.fiap.estudodecaso.exception.DBException;
import br.com.fiap.estudodecaso.model.Produto;

import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void cadastrar(Produto produto) throws DBException {

    }

    @Override
    public Produto buscar(int id) {
        return null;
    }

    @Override
    public List<Produto> listar() {
        return List.of();
    }

    @Override
    public void atualizar(Produto produto) throws DBException {

    }

    @Override
    public void remover(int codigo) throws DBException {

    }

}
