package br.com.fintech.Usuario;

import java.math.BigDecimal;

public class UsuarioPremium extends Usuario {

    public UsuarioPremium(
            String email, String nome, String sobrenome, String senha,
            BigDecimal capitalInicial, BigDecimal objetivoMonetario
    ) {
        super(email, nome, sobrenome, senha, capitalInicial, objetivoMonetario);
    }

    @Override
    public void getResumo() {
        System.out.println("[PREMIUM] " + getNome() + " " + getSobrenome() + " - (" + getEmail() + ")");
    }

    @Override
    public void getCotacao() {
        System.out.println(
                "Cotação em tempo real das principais moedas:" +
                "\n        -Dólar-   -Euro-  -Libra-" +
                "\nCOMPRA  R$5,612  R$6,208  R$7,342" +
                "\nVENDA   R$5,613  R$6,210  R$7,364"
        );
    }

}
