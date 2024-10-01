package br.com.fintech.factory;

import br.com.fintech.exception.TabelaNaoEncontradaException;
import br.com.fintech.exception.ValidacaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = System.getenv("url"); // Variáveis de ambiente para informações sensíveis
    private static final String USUARIO = System.getenv("usuario");
    private static final String SENHA = System.getenv("senha");

    public static Connection getConnection() throws TabelaNaoEncontradaException, ValidacaoException {
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            if (e.getErrorCode() == 942) {
                throw new TabelaNaoEncontradaException("TABELA", "tabela não encontrada.");
            }

            if (e.getErrorCode() == 1017) {
                throw new ValidacaoException();
            }
        }
        return connection;
    }

}
