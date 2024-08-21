package br.com.fintech;

import java.util.ArrayList;
import java.util.List;

public class CadastroAdicional {

    private Usuario usuario;
    private double capitalInicial;
    private boolean receberEmails;
    private boolean contaAtivada;
    private String pronomes;
    private List<Servico> servicosCadastrados;
    private List<Noticia> noticias;

    public CadastroAdicional() {
        this.servicosCadastrados = new ArrayList<Servico>();
        this.noticias = new ArrayList<Noticia>();
    }

    public CadastroAdicional(Usuario usuario, String pronomes) {
        this.usuario = usuario;
        this.capitalInicial = 0.0;
        this.receberEmails = false;
        this.contaAtivada = false;
        this.pronomes = pronomes;
        this.servicosCadastrados = List.of();
        this.noticias = List.of();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public CadastroAdicional setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public double getCapitalInicial() {
        return capitalInicial;
    }

    public CadastroAdicional setCapitalInicial(double capitalInicial) {
        this.capitalInicial = capitalInicial;
        return this;
    }

    public boolean isReceberEmails() {
        return receberEmails;
    }

    public CadastroAdicional setReceberEmails(boolean receberEmails) {
        this.receberEmails = receberEmails;
        return this;
    }

    public boolean isContaAtivada() {
        return contaAtivada;
    }

    public CadastroAdicional setContaAtivada(boolean contaAtivada) {
        this.contaAtivada = contaAtivada;
        return this;
    }

    public String getPronomes() {
        return pronomes;
    }

    public CadastroAdicional setPronomes(String pronomes) {
        this.pronomes = pronomes;
        return this;
    }

    public List<Servico> getServicosCadastrados() {
        return servicosCadastrados;
    }

    public CadastroAdicional setServicosCadastrados(Servico novoServico) {
        this.servicosCadastrados.add(novoServico);
        return this;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public CadastroAdicional setNoticias(Noticia noticia) {
        this.noticias.add(noticia);
        return this;
    }

    private double calcularValor() {

        double valorFinal = 0.0;

        for (Servico servico : servicosCadastrados) {
            valorFinal += servico.getValorAoMes();
        }
        return valorFinal;

    }

    @Override
    public String toString() {
        return "CadastroAdicional{" +
               "usuario=" + usuario.getId() +
               ", capitalInicial=R$" + capitalInicial +
               ", receberEmails=" + receberEmails +
               ", contaAtivada=" + contaAtivada +
               ", pronomes='" + pronomes + '\'' +
               ", servicosCadastrados=" + servicosCadastrados +
               ", valorTotalServicos=R$" + calcularValor() +
               ", noticiasCadastradasDoUsuario=" + noticias +
               "}";
    }



}
