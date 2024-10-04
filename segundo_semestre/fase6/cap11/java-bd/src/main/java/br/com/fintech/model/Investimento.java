package br.com.fintech.model;

import java.sql.Date;

public class Investimento {

    Long idInvestimento;
    Long idUsuario;
    String nmInvestimento;
    String descInvestimento;
    Date dtInicio;
    float valorInicial;
    int percentMensal;

    public Investimento() {
    }

    public Investimento(
            String nmInvestimento, String descInvestimento,
            Date dtInicio, float valorInicial, int percentMensal
    ) {
        this.nmInvestimento = nmInvestimento;
        this.descInvestimento = descInvestimento;
        this.dtInicio = dtInicio;
        this.valorInicial = valorInicial;
        this.percentMensal = percentMensal;
    }

    public Investimento(
            Long idInvestimento, Long idUsuario, String nmInvestimento, String descInvestimento,
            Date dtInicio, float valorInicial, int percentMensal
    ) {
        this.idInvestimento = idInvestimento;
        this.idUsuario = idUsuario;
        this.nmInvestimento = nmInvestimento;
        this.descInvestimento = descInvestimento;
        this.dtInicio = dtInicio;
        this.valorInicial = valorInicial;
        this.percentMensal = percentMensal;
    }

    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmInvestimento() {
        return nmInvestimento;
    }

    public void setNmInvestimento(String nmInvestimento) {
        this.nmInvestimento = nmInvestimento;
    }

    public String getDescInvestimento() {
        return descInvestimento;
    }

    public void setDescInvestimento(String descInvestimento) {
        this.descInvestimento = descInvestimento;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
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
               "id_investimento=" + idInvestimento +
               ", id_usuario=" + idUsuario +
               ", nm_investimento='" + nmInvestimento + '\'' +
               ", desc_investimento='" + descInvestimento + '\'' +
               ", dt_inicio=" + dtInicio +
               ", valor_inicial=" + valorInicial +
               ", percent_mensal=" + percentMensal +
               '}';
    }

}
