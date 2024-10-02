package br.com.fintech.model;

import java.sql.Date;

public class Investimento {

    Long id_investimento;
    Long id_usuario;
    String nm_investimento;
    String desc_investimento;
    Date dt_inicio;
    float valor_inicial;
    int percent_mensal;

    public Investimento() {
    }

    public Investimento(
            String nm_investimento, String desc_investimento,
            Date dt_inicio, float valor_inicial, int percent_mensal
    ) {
        this.nm_investimento = nm_investimento;
        this.desc_investimento = desc_investimento;
        this.dt_inicio = dt_inicio;
        this.valor_inicial = valor_inicial;
        this.percent_mensal = percent_mensal;
    }

    public Investimento(
            Long id_investimento, Long id_usuario, String nm_investimento, String desc_investimento,
            Date dt_inicio, float valor_inicial, int percent_mensal
    ) {
        this.id_investimento = id_investimento;
        this.id_usuario = id_usuario;
        this.nm_investimento = nm_investimento;
        this.desc_investimento = desc_investimento;
        this.dt_inicio = dt_inicio;
        this.valor_inicial = valor_inicial;
        this.percent_mensal = percent_mensal;
    }

    public Long getId_investimento() {
        return id_investimento;
    }

    public void setId_investimento(Long id_investimento) {
        this.id_investimento = id_investimento;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNm_investimento() {
        return nm_investimento;
    }

    public void setNm_investimento(String nm_investimento) {
        this.nm_investimento = nm_investimento;
    }

    public String getDesc_investimento() {
        return desc_investimento;
    }

    public void setDesc_investimento(String desc_investimento) {
        this.desc_investimento = desc_investimento;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public float getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(float valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public int getPercent_mensal() {
        return percent_mensal;
    }

    public void setPercent_mensal(int percent_mensal) {
        this.percent_mensal = percent_mensal;
    }

    @Override
    public String toString() {
        return "Investimento{" +
               "id_investimento=" + id_investimento +
               ", id_usuario=" + id_usuario +
               ", nm_investimento='" + nm_investimento + '\'' +
               ", desc_investimento='" + desc_investimento + '\'' +
               ", dt_inicio=" + dt_inicio +
               ", valor_inicial=" + valor_inicial +
               ", percent_mensal=" + percent_mensal +
               '}';
    }

}
