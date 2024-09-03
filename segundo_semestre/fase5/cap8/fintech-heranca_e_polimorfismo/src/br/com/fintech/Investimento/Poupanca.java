package br.com.fintech.Investimento;

public class Poupanca extends Investimento {

    private static final double TAXA_FIXA = 0.005;

    public Poupanca(double valorInicial) {
        super(valorInicial, TAXA_FIXA);
    }

    @Override
    public String calcularRetorno(int meses) {
        double valFinal = valorInicial * Math.pow(1 + taxaDeJuros, meses) - valorInicial;

        return String.format("%.2f", valFinal);
    }

}
