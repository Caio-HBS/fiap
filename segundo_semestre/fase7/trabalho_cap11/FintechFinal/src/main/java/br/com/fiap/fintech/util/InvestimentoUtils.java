package br.com.fiap.fintech.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe utilitária para cálculo de rendimento de investimentos com base em percentuais mensais.
 * <p>
 * O cálculo é feito aplicando juros compostos ao valor inicial do investimento, a partir da data
 * de início até a data atual. Retorna o valor final como uma string, truncando o valor para
 * até seis caracteres caso seja necessário (para formatação na view).
 * </p>
 *
 * <p>Exemplo de Uso:</p>
 * <pre>
 *     String rendimento = InvestimentoUtils.calcularRendimento(1000, 2, LocalDate.of(2022, 1, 1));
 * </pre>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>valor</code>: O valor inicial do investimento.</li>
 *     <li><code>percent</code>: Percentual de rendimento mensal.</li>
 *     <li><code>dtInicio</code>: Data de início do investimento.</li>
 * </ul>
 *
 * <p>Retorno:</p>
 * <ul>
 *     <li>Uma string com o rendimento final, truncada para seis caracteres se exceder cinco dígitos.</li>
 * </ul>
 *
 * @see java.time.LocalDate
 */
public class InvestimentoUtils {

    public static String calcularRendimento(double valor, int percent, LocalDate dtInicio) {

        LocalDate hoje = LocalDate.now();

        Period period = Period.between(dtInicio, hoje);
        int difMeses = period.getYears() * 12 + period.getMonths();

        double resultado = (
                valor * Math.pow(1 + ((double) percent / 100), difMeses)
        );

        String rend = String.valueOf((int) resultado);
        if (rend.length() <= 5) {
            return rend;
        } else {
            return rend.substring(0, 6);
        }

    }

}
