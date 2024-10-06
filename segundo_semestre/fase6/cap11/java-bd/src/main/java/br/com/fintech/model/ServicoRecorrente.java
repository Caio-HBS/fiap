package br.com.fintech.model;

import java.sql.Date;

public class ServicoRecorrente {

    Long idServRecorrente;
    Long idUsuario;
    Long idContaBancaria;
    String nmServico;
    String descServico;
    Date dtRegistroServ;
    Date dtLimite;
    String frequencia;
    double valorOperacao;
    char operacaoEfetuada;
    char aPagar;
    char aReceber;

    public ServicoRecorrente() {
    }

    public ServicoRecorrente(
            String nmServico, String descServico, Date dtRegistroServ, Date dtLimite, String frequencia,
            double valorOperacao, char operacaoEfetuada, char aPagar, char aReceber
    ) {
        this.nmServico = nmServico;
        this.descServico = descServico;
        this.dtRegistroServ = dtRegistroServ;
        this.dtLimite = dtLimite;
        this.frequencia = frequencia;
        this.valorOperacao = valorOperacao;
        this.operacaoEfetuada = operacaoEfetuada;
        this.aPagar = aPagar;
        this.aReceber = aReceber;
    }

    public ServicoRecorrente(
            Long idServRecorrente, Long idUsuario, Long idContaBancaria, String nmServico, String descServico,
            Date dtRegistroServ, Date dtLimite, String frequencia, double valorOperacao, char operacaoEfetuada,
            char aPagar, char aReceber
    ) {
        this.idServRecorrente = idServRecorrente;
        this.idUsuario = idUsuario;
        this.idContaBancaria = idContaBancaria;
        this.nmServico = nmServico;
        this.descServico = descServico;
        this.dtRegistroServ = dtRegistroServ;
        this.dtLimite = dtLimite;
        this.frequencia = frequencia;
        this.valorOperacao = valorOperacao;
        this.operacaoEfetuada = operacaoEfetuada;
        this.aPagar = aPagar;
        this.aReceber = aReceber;
    }

    public Long getIdServRecorrente() {
        return idServRecorrente;
    }

    public void setIdServRecorrente(Long idServRecorrente) {
        this.idServRecorrente = idServRecorrente;
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

    public Date getDtLimite() {
        return dtLimite;
    }

    public void setDtLimite(Date dtLimite) {
        this.dtLimite = dtLimite;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public char getOperacaoEfetuada() {
        return operacaoEfetuada;
    }

    public void setOperacaoEfetuada(char operacaoEfetuada) {
        this.operacaoEfetuada = operacaoEfetuada;
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
        return "ServicoRecorrente{" +
               "idServRecorrente=" + idServRecorrente +
               ", idUsuario=" + idUsuario +
               ", idContaBancaria=" + idContaBancaria +
               ", nmServico='" + nmServico + '\'' +
               ", descServico='" + descServico + '\'' +
               ", dtRegistroServ=" + dtRegistroServ +
               ", dtLimite=" + dtLimite +
               ", frequencia='" + frequencia + '\'' +
               ", valorOperacao=" + valorOperacao +
               ", operacaoEfetuada=" + operacaoEfetuada +
               ", aPagar=" + aPagar +
               ", aReceber=" + aReceber +
               '}';
    }
}
