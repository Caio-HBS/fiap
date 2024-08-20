package br.com.fintech;

import java.util.List;

public class CadastroAdicional {

    private Usuario usuario;
    private double capitalInicial;
    private boolean receberEmails;
    private boolean contaAtivada;
    private String pronomes;
    private List<Servico> servicosCadastrados;

    public CadastroAdicional() {
    }

    public CadastroAdicional(
            Usuario usuario, double capitalInicial, boolean receberEmails,
            boolean contaAtivada, String pronomes, List<Servico> servicosCadastrados
    ) {
        this.usuario = usuario;
        this.capitalInicial = capitalInicial;
        this.receberEmails = receberEmails;
        this.contaAtivada = contaAtivada;
        this.pronomes = pronomes;
        this.servicosCadastrados = servicosCadastrados;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public boolean isReceberEmails() {
        return receberEmails;
    }

    public void setReceberEmails(boolean receberEmails) {
        this.receberEmails = receberEmails;
    }

    public boolean isContaAtivada() {
        return contaAtivada;
    }

    public void setContaAtivada(boolean contaAtivada) {
        this.contaAtivada = contaAtivada;
    }

    public String getPronomes() {
        return pronomes;
    }

    public void setPronomes(String pronomes) {
        this.pronomes = pronomes;
    }

    public List<Servico> getServicosCadastrados() {
        return servicosCadastrados;
    }

    public void setServicosCadastrados(Servico novoServico) {
        this.servicosCadastrados.add(novoServico);
    }

    @Override
    public String toString() {
        return "CadastroAdicional{" +
               "usuario=" + usuario +
               ", capitalInicial=" + capitalInicial +
               ", receberEmails=" + receberEmails +
               ", contaAtivada=" + contaAtivada +
               ", pronomes='" + pronomes + '\'' +
               ", servicosCadastrados=" + servicosCadastrados +
               '}';
    }

}
