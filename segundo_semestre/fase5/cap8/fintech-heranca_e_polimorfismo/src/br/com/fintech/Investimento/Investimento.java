package br.com.fintech.Investimento;

public abstract class Investimento {

    protected double valorInicial;
    protected double taxaDeJuros;

    public Investimento(double valorInicial, double taxaDeJuros) {
        this.valorInicial = valorInicial;
        this.taxaDeJuros = taxaDeJuros;
    }

    public abstract String calcularRetorno(int periodos);

    public void exibirInformacoes() {
        System.out.println("Valor Inicial: " + valorInicial);
        System.out.println("Taxa de Juros: " + taxaDeJuros + "%");
    }

}