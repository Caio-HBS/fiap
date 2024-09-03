package br.com.fintech.Servico;

import java.util.Date;

public abstract class Servico {

    private String nomeServico;
    private String descricaoServico;
    private double valorDoServico;
    private Date dataDoServico;

    public Servico() {
    }

    public Servico(String nomeServico, String descricaoServico, double valorDoServico) {
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
        this.valorDoServico = valorDoServico;
        this.dataDoServico = new Date();
    }

    public abstract void getResumo();

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public double getValorDoServico() {
        return valorDoServico;
    }

    public void setValorDoServico(double valorDoServico) {
        this.valorDoServico = valorDoServico;
    }

    public Date getDataDoServico() {
        return dataDoServico;
    }

    public void setDataDoServico(Date dataDoServico) {
        this.dataDoServico = dataDoServico;
    }

}
