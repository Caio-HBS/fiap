package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Investimento {

    private int idInvestimento;
    private int idUsuario;
    private String nomeInvestimento;
    private String descricaoInvestimento;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double valorInicial;
    private int percentMensal;

    public Investimento() {
    }

    public Investimento(
            int idUsuario, String nomeInvestimento, String descricaoInvestimento, LocalDate dataInicio,
            LocalDate dataTermino, double valorInicial, int percentMensal
    ) {
        this.idUsuario = idUsuario;
        this.nomeInvestimento = nomeInvestimento;
        this.descricaoInvestimento = descricaoInvestimento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorInicial = valorInicial;
        this.percentMensal = percentMensal;
    }

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    public String getDescricaoInvestimento() {
        return descricaoInvestimento;
    }

    public void setDescricaoInvestimento(String descricaoInvestimento) {
        this.descricaoInvestimento = descricaoInvestimento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getPercentMensal() {
        return percentMensal;
    }

    public void setPercentMensal(int percentMensal) {
        this.percentMensal = percentMensal;
    }

    @Override
    public String toString() {
        return "Investimento{" +
               "idInvestimento=" + idInvestimento +
               ", idUsuario=" + idUsuario +
               ", nomeInvestimento='" + nomeInvestimento + '\'' +
               ", descricaoInvestimento='" + descricaoInvestimento + '\'' +
               ", dataInicio=" + dataInicio +
               ", dataTermino=" + dataTermino +
               ", valorInicial=" + valorInicial +
               ", percentMensal=" + percentMensal +
               '}';
    }

}
