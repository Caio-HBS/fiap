package br.com.fintech.exception;

public class ErroNaQueryException extends Exception {
    public ErroNaQueryException(String message) {
        super("Verifique a consulta (query) e tente novamente - \"" + message.trim() + "\"");
    }
}
