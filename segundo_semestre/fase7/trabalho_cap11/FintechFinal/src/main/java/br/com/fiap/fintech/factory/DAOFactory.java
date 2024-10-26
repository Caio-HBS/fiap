package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.Impl.OracleUsuarioDAO;
import br.com.fiap.fintech.dao.Impl.OracleUsuarioInfoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.UsuarioInfoDAO;


public class DAOFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new OracleUsuarioDAO();
    }

    public static UsuarioInfoDAO getUsuarioInfoDAO() {
        return new OracleUsuarioInfoDAO();
    }

}
