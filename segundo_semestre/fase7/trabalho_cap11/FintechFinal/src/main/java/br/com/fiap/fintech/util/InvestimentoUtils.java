package br.com.fiap.fintech.util;

import br.com.fiap.fintech.model.DashboardInfo;

import java.time.LocalDate;
import java.time.Period;

public class InvestimentoUtils {

    public static String calcularRendimento(double valor, int percent, LocalDate dtInicio) {

        LocalDate inicioInv = dtInicio;
        LocalDate hoje = LocalDate.now();

        Period period = Period.between(inicioInv, hoje);
        int difMeses = period.getYears() * 12 + period.getMonths();

        double resultado = (
                valor * Math.pow(1 + ((double) percent / 100),
                        difMeses)
        );

        String rend = String.valueOf((int) resultado);
        if (rend.length() <= 5) {
            return rend;
        } else {
            return rend.substring(0, 6);
        }

    }

}
