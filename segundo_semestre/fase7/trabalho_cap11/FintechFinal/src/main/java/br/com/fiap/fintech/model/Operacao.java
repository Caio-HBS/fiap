package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Operacao {

    private int idOperacao;
    private int idUsuario;
    private String nomeOperacao;
    private String descricaoOperacao;
    private LocalDate dataRegistro;
    private LocalDate dataOperacao;
    private double valorOperacao;
    private char tipoOperacao;

    public Operacao() {
    }

    public Operacao(
            int idOperacao, int idUsuario, String nomeOperacao, String descricaoOperacao, LocalDate dataRegistro,
            LocalDate dataOperacao, double valorOperacao, char tipoOperacao
    ) {
        this.idOperacao = idOperacao;
        this.idUsuario = idUsuario;
        this.nomeOperacao = nomeOperacao;
        this.descricaoOperacao = descricaoOperacao;
        this.dataRegistro = dataRegistro;
        this.dataOperacao = dataOperacao;
        this.valorOperacao = valorOperacao;
        this.tipoOperacao = tipoOperacao;
    }

    public Operacao(
            int idUsuario, String nomeOperacao, String descricaoOperacao, LocalDate dataRegistro,
            LocalDate dataOperacao, double valorOperacao, char tipoOperacao
    ) {
        this.idUsuario = idUsuario;
        this.nomeOperacao = nomeOperacao;
        this.descricaoOperacao = descricaoOperacao;
        this.dataRegistro = dataRegistro;
        this.dataOperacao = dataOperacao;
        this.valorOperacao = valorOperacao;
        this.tipoOperacao = tipoOperacao;
    }

    public int getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(int idOperacao) {
        this.idOperacao = idOperacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeOperacao() {
        return nomeOperacao;
    }

    public void setNomeOperacao(String nomeOperacao) {
        this.nomeOperacao = nomeOperacao;
    }

    public String getDescricaoOperacao() {
        return descricaoOperacao;
    }

    public void setDescricaoOperacao(String descricaoOperacao) {
        this.descricaoOperacao = descricaoOperacao;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public char getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(char tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    @Override
    public String toString() {
        return "Operacao{" +
               "idOperacao=" + idOperacao +
               ", idUsuario=" + idUsuario +
               ", nomeOperacao='" + nomeOperacao + '\'' +
               ", descricaoOperacao='" + descricaoOperacao + '\'' +
               ", dataRegistro=" + dataRegistro +
               ", dataOperacao=" + dataOperacao +
               ", valorOperacao=" + valorOperacao +
               ", tipoOperacao=" + tipoOperacao +
               '}';
    }

}
