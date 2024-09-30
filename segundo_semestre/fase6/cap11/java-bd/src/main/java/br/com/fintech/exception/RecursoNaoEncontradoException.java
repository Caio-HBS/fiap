package br.com.fintech.exception;

public class RecursoNaoEncontradoException extends Exception {

    public RecursoNaoEncontradoException() {
    }
    public RecursoNaoEncontradoException(String recurso, String mensagem) {
        super(recurso + ": " + mensagem);
    }

}
