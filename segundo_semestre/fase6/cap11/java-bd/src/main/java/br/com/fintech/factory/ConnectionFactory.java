package br.com.fintech.factory;

import br.com.fintech.exception.GenericaException;
import br.com.fintech.exception.NaoFoiPossivelConectarException;
import br.com.fintech.exception.TabelaNaoEncontradaException;
import br.com.fintech.exception.ValidacaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Utilização de variáveis de ambiente para guardar e recuperar informações sensíveis
    private static final String URL = System.getenv("url");
    private static final String USUARIO = System.getenv("usuario");
    private static final String SENHA = System.getenv("senha");

    public static Connection getConnection(
    ) throws TabelaNaoEncontradaException, ValidacaoException, NaoFoiPossivelConectarException, GenericaException {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            // Tratamento de exceções mais comuns baseado no código.
            if (e.getErrorCode() == 942) {
                throw new TabelaNaoEncontradaException("Tabela não encontrada. Verifique a query.");
            }
            if (e.getErrorCode() == 1017) {
                throw new ValidacaoException();
            }
            if (e.getErrorCode() == 12514) {
                throw new NaoFoiPossivelConectarException(e.getErrorCode());
            } else {
                throw new GenericaException(e.getMessage(), e.getErrorCode());
            }
        }

    }

}
