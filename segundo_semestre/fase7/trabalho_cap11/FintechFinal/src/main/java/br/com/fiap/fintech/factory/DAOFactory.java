package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.Impl.OracleUsuarioDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;

public class DAOFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new OracleUsuarioDAO();
    }

}
