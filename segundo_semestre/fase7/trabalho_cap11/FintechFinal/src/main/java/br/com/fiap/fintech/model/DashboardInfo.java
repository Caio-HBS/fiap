package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class DashboardInfo {

    private String nmUltimaDespesa;
    private LocalDate dtUltimaDespesa;
    private double valorUltimaDespesa;
    private String nmUltimaReceita;
    private LocalDate dtUltimaReceita;
    private double valorUltimaReceita;
    private String nmUltimoInvestimento;
    private double valorUltimoInvestimento;
    private int percentUltimoInvestimento;
    private LocalDate dtInicioUltimoInvestimento;

    public DashboardInfo() {
    }

    public DashboardInfo(
            String nmUltimaDespesa, LocalDate dtUltimaDespesa, double valorUltimaDespesa, String nmUltimaReceita,
            LocalDate dtUltimaReceita, double valorUltimaReceita, String nmUltimoInvestimento,
            double valorUltimoInvestimento, int percentUltimoInvestimento, LocalDate dtInicioUltimoInvestimento
    ) {
        this.nmUltimaDespesa = nmUltimaDespesa;
        this.dtUltimaDespesa = dtUltimaDespesa;
        this.valorUltimaDespesa = valorUltimaDespesa;
        this.nmUltimaReceita = nmUltimaReceita;
        this.dtUltimaReceita = dtUltimaReceita;
        this.valorUltimaReceita = valorUltimaReceita;
        this.nmUltimoInvestimento = nmUltimoInvestimento;
        this.valorUltimoInvestimento = valorUltimoInvestimento;
        this.percentUltimoInvestimento = percentUltimoInvestimento;
        this.dtInicioUltimoInvestimento = dtInicioUltimoInvestimento;
    }

    public String getNmUltimaDespesa() {
        return nmUltimaDespesa;
    }

    public void setNmUltimaDespesa(String nmUltimaDespesa) {
        this.nmUltimaDespesa = nmUltimaDespesa;
    }

    public LocalDate getDtUltimaDespesa() {
        return dtUltimaDespesa;
    }

    public void setDtUltimaDespesa(LocalDate dtUltimaDespesa) {
        this.dtUltimaDespesa = dtUltimaDespesa;
    }

    public double getValorUltimaDespesa() {
        return valorUltimaDespesa;
    }

    public void setValorUltimaDespesa(double valorUltimaDespesa) {
        this.valorUltimaDespesa = valorUltimaDespesa;
    }

    public String getNmUltimaReceita() {
        return nmUltimaReceita;
    }

    public void setNmUltimaReceita(String nmUltimaReceita) {
        this.nmUltimaReceita = nmUltimaReceita;
    }

    public LocalDate getDtUltimaReceita() {
        return dtUltimaReceita;
    }

    public void setDtUltimaReceita(LocalDate dtUltimaReceita) {
        this.dtUltimaReceita = dtUltimaReceita;
    }

    public double getValorUltimaReceita() {
        return valorUltimaReceita;
    }

    public void setValorUltimaReceita(double valorUltimaReceita) {
        this.valorUltimaReceita = valorUltimaReceita;
    }

    public String getNmUltimoInvestimento() {
        return nmUltimoInvestimento;
    }

    public void setNmUltimoInvestimento(String nmUltimoInvestimento) {
        this.nmUltimoInvestimento = nmUltimoInvestimento;
    }

    public double getValorUltimoInvestimento() {
        return valorUltimoInvestimento;
    }

    public void setValorUltimoInvestimento(double valorUltimoInvestimento) {
        this.valorUltimoInvestimento = valorUltimoInvestimento;
    }

    public int getPercentUltimoInvestimento() {
        return percentUltimoInvestimento;
    }

    public void setPercentUltimoInvestimento(int percentUltimoInvestimento) {
        this.percentUltimoInvestimento = percentUltimoInvestimento;
    }

    public LocalDate getDtInicioUltimoInvestimento() {
        return dtInicioUltimoInvestimento;
    }

    public void setDtInicioUltimoInvestimento(LocalDate dtInicioUltimoInvestimento) {
        this.dtInicioUltimoInvestimento = dtInicioUltimoInvestimento;
    }

    @Override
    public String toString() {
        return "DashboardInfo{" +
               "nmUltimaDespesa='" + nmUltimaDespesa + '\'' +
               ", dtUltimaDespesa=" + dtUltimaDespesa +
               ", valorUltimaDespesa=" + valorUltimaDespesa +
               ", nmUltimaReceita='" + nmUltimaReceita + '\'' +
               ", dtUltimaReceita=" + dtUltimaReceita +
               ", valorUltimaReceita=" + valorUltimaReceita +
               ", nmUltimoInvestimento='" + nmUltimoInvestimento + '\'' +
               ", valorUltimoInvestimento=" + valorUltimoInvestimento +
               ", percentUltimoInvestimento=" + percentUltimoInvestimento +
               ", dtInicioUltimoInvestimento=" + dtInicioUltimoInvestimento +
               '}';
    }

}
