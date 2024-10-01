package br.com.fintech.exception;

public class ValidacaoException extends Exception {

    public ValidacaoException() {
        super("Validação falhou, verifique suas credenciais.");
    }

}
