package br.com.fintech.exception;

public class NaoFoiPossivelConectarException extends Exception {

    public NaoFoiPossivelConectarException(int code) {
        super("Não foi possível estabelecer a conexão com o banco de dados. Código: " + code + ")");
    }

}
