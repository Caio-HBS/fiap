package br.com.fintech.exception;

public class EntidadeNaoEncontradaException extends Exception {

    public EntidadeNaoEncontradaException(String recurso, String mensagem) {
        super(recurso + ": " + mensagem);
    }

}
