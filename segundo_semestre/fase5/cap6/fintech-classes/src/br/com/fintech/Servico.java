package br.com.fintech;

import java.time.LocalDate;

public class Servico {

    private String item;
    private String descricao;
    private double valorAoMes;
    private LocalDate dataCadastro;

    public Servico() {
    }

    public Servico(String item, String descricao, double valorAoMes, LocalDate dataCadastro) {
        this.item = item;
        this.descricao = descricao;
        this.valorAoMes = valorAoMes;
        this.dataCadastro = dataCadastro;
    }

    public String getItem() {
        return item;
    }

    public Servico setItem(String item) {
        this.item = item;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Servico setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public double getValorAoMes() {
        return valorAoMes;
    }

    public Servico setValorAoMes(double valorAoMes) {
        this.valorAoMes = valorAoMes;
        return this;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Servico setDataCadastro(LocalDate proximoPagamento) {
        this.dataCadastro = proximoPagamento;
        return this;
    }

    private String proximoPagamento() {
        LocalDate atual = LocalDate.now();
        int diaAtual = atual.getDayOfMonth();
        int mes = atual.getMonthValue();

        int diaDoPagamento = dataCadastro.getDayOfMonth();

        if (diaAtual >= diaDoPagamento) {
            mes += 1;
        }

        return diaDoPagamento + "-" + mes;
    }

    @Override
    public String toString() {
        return "Servico{" +
               ", item='" + item + '\'' +
               ", descricao='" + descricao + '\'' +
               ", valorAoMes=R$" + valorAoMes +
               ", dataCadastro=" + dataCadastro +
               ", proximoPagamento=" + proximoPagamento() +
               "}";
    }

}
