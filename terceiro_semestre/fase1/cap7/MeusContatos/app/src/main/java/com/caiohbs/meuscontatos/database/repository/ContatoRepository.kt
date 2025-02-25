package com.caiohbs.meuscontatos.database.repository

import android.content.Context
import com.caiohbs.meuscontatos.model.Contato
import com.caiohbs.meuscontatos.database.dao.ContatoDb

class ContatoRepository(context: Context) {

    private val db = ContatoDb.getDatabase(context).contatoDao()

    fun salvar(contato: Contato): Long {
        return db.salvar(contato)
    }

    fun atualizar(contato: Contato): Int {
        return db.atualizar(contato)
    }

    fun excluir(contato: Contato): Int {
        return db.excluir(contato)
    }

    fun listarContatos(): List<Contato> {
        return db.listarContatos()
    }

    fun buscarContatoPeloId(id: Int): Contato {
        return db.buscarContatoPeloId(id)
    }

}