package br.com.fintech.Investimento;

public class RendaFixa extends Investimento {
    private double taxaDeIR;

    public RendaFixa(double valorInicial, double taxaDeJuros, double taxaDeIR) {
        super(valorInicial, taxaDeJuros);
        this.taxaDeIR = taxaDeIR;
    }

    @Override
    public String calcularRetorno(int anos) {
        double montante = valorInicial * Math.pow(1 + taxaDeJuros, anos);
        double lucro = montante - valorInicial;
        double valFinal = lucro * (1 - taxaDeIR);

        return String.format("%.2f", valFinal);
    }
}
