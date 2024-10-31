package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.*;
import br.com.fiap.fintech.dao.impl.*;


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

    public static NoticiaDAO getNoticiaDAO() {
        return new OracleNoticiaDAO();
    }

    public static InvestimentoDAO getInvestimentoDAO() {
        return new OracleInvestimentoDAO();
    }

}
