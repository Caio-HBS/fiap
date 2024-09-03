package br.com.fintech.Servico;

public class ServicoRecorrente extends Servico {

    private int frequenciaEmDias;

    public ServicoRecorrente(
            String nomeServico, String descricaoServico, double valorDoServico, int frequenciaEmDias
    ) {
        super(nomeServico, descricaoServico, valorDoServico);
        this.frequenciaEmDias = frequenciaEmDias;
    }

    public int getFrequenciaEmDias() {
        return frequenciaEmDias;
    }

    public void setFrequenciaEmDias(int frequenciaEmDias) {
        this.frequenciaEmDias = frequenciaEmDias;
    }

    @Override
    public void getResumo() {
        System.out.println("Serviço RECORRENTE: " + getNomeServico() + " - " + getDescricaoServico() +
               " - Valor: R$" + getValorDoServico() + " - Frequência: a cada " + frequenciaEmDias + " dias");
    }

}
