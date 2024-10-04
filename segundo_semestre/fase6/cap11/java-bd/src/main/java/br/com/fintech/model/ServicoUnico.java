package br.com.fintech.model;

import java.sql.Date;

public class ServicoUnico {
    Long idServUnico;
    Long idUsuario;
    Long idContaBancaria;
    String nmServico;
    String descServico;
    Date dtRegistroServ;
    Date dtOperacao;
    double valorOperacao;
    char aPagar;
    char aReceber;

    public ServicoUnico() {
    }

    public ServicoUnico(
            String nmServico, String descServico, Date dtRegistroServ, Date dtOperacao,
            double valorOperacao, char aPagar, char aReceber
    ) {
        this.nmServico = nmServico;
        this.descServico = descServico;
        this.dtRegistroServ = dtRegistroServ;
        this.dtOperacao = dtOperacao;
        this.valorOperacao = valorOperacao;
        this.aPagar = aPagar;
        this.aReceber = aReceber;
    }

    public ServicoUnico(
            Long idServUnico, Long idUsuario, Long idContaBancaria, String nm_servico, String desc_servico,
            Date dt_registro_serv, Date dt_operacao, double valor_operacao, char a_pagar, char a_receber
    ) {
        this.idServUnico = idServUnico;
        this.idUsuario = idUsuario;
        this.idContaBancaria = idContaBancaria;
        this.nmServico = nmServico;
        this.descServico = descServico;
        this.dtRegistroServ = dtRegistroServ;
        this.dtOperacao = dtOperacao;
        this.valorOperacao = valorOperacao;
        this.aPagar = aPagar;
        this.aReceber = aReceber;
    }

    public Long getIdServUnico() {
        return idServUnico;
    }

    public void setIdServUnico(Long idServUnico) {
        this.idServUnico = idServUnico;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdContaBancaria() {
        return idContaBancaria;
    }

    public void setIdContaBancaria(Long idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public String getDescServico() {
        return descServico;
    }

    public void setDescServico(String descServico) {
        this.descServico = descServico;
    }

    public Date getDtRegistroServ() {
        return dtRegistroServ;
    }

    public void setDtRegistroServ(Date dtRegistroServ) {
        this.dtRegistroServ = dtRegistroServ;
    }

    public Date getDtOperacao() {
        return dtOperacao;
    }

    public void setDtOperacao(Date dtOperacao) {
        this.dtOperacao = dtOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public char getaPagar() {
        return aPagar;
    }

    public void setaPagar(char aPagar) {
        this.aPagar = aPagar;
    }

    public char getaReceber() {
        return aReceber;
    }

    public void setaReceber(char aReceber) {
        this.aReceber = aReceber;
    }

    @Override
    public String toString() {
        return "ServicoUnico{" +
               "idServUnico=" + idServUnico +
               ", idUsuario=" + idUsuario +
               ", idContaBancaria=" + idContaBancaria +
               ", nmServico='" + nmServico + '\'' +
               ", descServico='" + descServico + '\'' +
               ", dtRegistroServ=" + dtRegistroServ +
               ", dtOperacao=" + dtOperacao +
               ", valorOperacao=" + valorOperacao +
               ", aPagar=" + aPagar +
               ", aReceber=" + aReceber +
               '}';
    }

}
