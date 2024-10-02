package br.com.fintech.exception;

public class GenericaException extends Exception {
    public GenericaException(String message, int code) {
        super(code + ": " + message);
    }
}
