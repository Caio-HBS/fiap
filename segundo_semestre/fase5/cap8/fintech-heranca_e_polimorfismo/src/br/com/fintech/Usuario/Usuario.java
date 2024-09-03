package br.com.fintech.Usuario;

import br.com.fintech.Investimento.Investimento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    private String email;
    private String nome;
    private String sobrenome;
    private String senha;
    private BigDecimal capitalInicial;
    private BigDecimal capitalAtual;
    private BigDecimal objetivoMonetario;
    private List<Investimento> investimentos;
    private boolean isEmailVerificado;

    public Usuario() {
    }

    public Usuario(
            String email, String nome, String sobrenome, String senha,
            BigDecimal capitalInicial, BigDecimal objetivoMonetario
    ) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.capitalInicial = capitalInicial;
        this.capitalAtual = capitalInicial;
        this.objetivoMonetario = objetivoMonetario;
        this.investimentos = new ArrayList<>();
    }

    public abstract void getResumo();

    public abstract void getCotacao();

    public abstract void getGrafico();

    public void getObjetivo() {
        BigDecimal objetivo = objetivoMonetario.subtract(capitalAtual);

        if (objetivo.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("Você está a R$" + objetivo + " do seu objetivo!");
            return;
        }

        System.out.println("Você atingiu seu objetivo monetário e está R$" + objetivo.abs() + " acima " +
                           "dele!");

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(BigDecimal capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public BigDecimal getCapitalAtual() {
        return capitalAtual;
    }

    public void setCapitalAtual(BigDecimal capitalAtual) {
        this.capitalAtual = capitalAtual;
    }

    public BigDecimal getObjetivoMonetario() {
        return objetivoMonetario;
    }

    public void setObjetivoMonetario(BigDecimal objetivoMonetario) {
        this.objetivoMonetario = objetivoMonetario;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(Investimento investimento) {
        this.investimentos.add(investimento);
    }

    public boolean isEmailVerificado() {
        return isEmailVerificado;
    }

    public void setEmailVerificado(boolean emailVerificado) {
        isEmailVerificado = emailVerificado;
    }

}
