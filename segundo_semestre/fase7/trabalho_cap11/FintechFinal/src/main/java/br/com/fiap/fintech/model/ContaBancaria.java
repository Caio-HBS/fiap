package br.com.fiap.fintech.model;

public class ContaBancaria {

    private int idContaBancaria;
    private int idUsuario;
    private char tipoConta;
    private int agencia;
    private int cdVerificacaoAgencia;
    private String numeroContaBancaria; // Número de 12 dígitos
    private int cdVerificacaoConta;

    public ContaBancaria() {
    }

    public ContaBancaria(
            int idUsuario, char tipoConta, int agencia, int cdVerificacaoAgencia,
            String numeroContaBancaria, int cdVerificacaoConta
    ) {
        this.idUsuario = idUsuario;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.cdVerificacaoAgencia = cdVerificacaoAgencia;
        this.numeroContaBancaria = numeroContaBancaria;
        this.cdVerificacaoConta = cdVerificacaoConta;
    }

    public int getIdContaBancaria() {
        return idContaBancaria;
    }

    public void setIdContaBancaria(int idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public char getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(char tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getCdVerificacaoAgencia() {
        return cdVerificacaoAgencia;
    }

    public void setCdVerificacaoAgencia(int cdVerificacaoAgencia) {
        this.cdVerificacaoAgencia = cdVerificacaoAgencia;
    }

    public String getNumeroContaBancaria() {
        return numeroContaBancaria;
    }

    public void setNumeroContaBancaria(String numeroContaBancaria) {
        this.numeroContaBancaria = numeroContaBancaria;
    }

    public int getCdVerificacaoConta() {
        return cdVerificacaoConta;
    }

    public void setCdVerificacaoConta(int cdVerificacaoConta) {
        this.cdVerificacaoConta = cdVerificacaoConta;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
               "idContaBancaria=" + idContaBancaria +
               ", idUsuario=" + idUsuario +
               ", tipoConta=" + tipoConta +
               ", agencia=" + agencia +
               ", cdVerificacaoAgencia=" + cdVerificacaoAgencia +
               ", numeroContaBancaria='" + numeroContaBancaria + '\'' +
               ", cdVerificacaoConta=" + cdVerificacaoConta +
               '}';
    }

}
