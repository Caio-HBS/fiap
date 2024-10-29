package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.DashboardInfoDAO;
import br.com.fiap.fintech.dao.OperacaoDAO;
import br.com.fiap.fintech.dao.impl.OracleDashboardInfoDAO;
import br.com.fiap.fintech.dao.impl.OracleOperacaoDAO;
import br.com.fiap.fintech.dao.impl.OracleUsuarioDAO;
import br.com.fiap.fintech.dao.impl.OracleUsuarioInfoDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.UsuarioInfoDAO;


public class DAOFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new OracleUsuarioDAO();
    }

    public static UsuarioInfoDAO getUsuarioInfoDAO() {
        return new OracleUsuarioInfoDAO();
    }

    public static DashboardInfoDAO getDashboardInfoDAO() {
        return new OracleDashboardInfoDAO();
    }
    public static OperacaoDAO getOperacaoDAO() {
        return new OracleOperacaoDAO();
    }

}
