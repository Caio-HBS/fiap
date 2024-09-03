package br.com.fintech.Servico;

import java.text.SimpleDateFormat;

public class ServicoUnico extends Servico {

    public ServicoUnico(String nomeServico, String descricaoServico, double valorDoServico) {
        super(nomeServico, descricaoServico, valorDoServico);
    }

    @Override
    public void getResumo() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Serviço ÚNICO: " + getNomeServico() + " - " + getDescricaoServico() +
               " - Valor: R$" + getValorDoServico() + " - Data de cadastro do serviço: " + formatador.format(getDataDoServico()));
    }

}

