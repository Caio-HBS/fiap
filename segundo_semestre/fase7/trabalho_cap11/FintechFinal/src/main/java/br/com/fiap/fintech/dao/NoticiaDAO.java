package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.model.Noticia;

import java.util.List;

public interface NoticiaDAO {

    Noticia buscarPorId(int id);

    List<Noticia> listar();

}
