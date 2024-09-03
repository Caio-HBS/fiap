package br.com.fintech.Usuario;

import java.math.BigDecimal;

public class UsuarioFree extends Usuario {

    private final String ERRO_PREMIUM = "ERRO: Esse recurso só está disponível para usuários premium,\n" +
                                        "acesse https://fintech.com/assinar-premium para mais informações.";

    public UsuarioFree(
            String email, String nome, String sobrenome, String senha,
            BigDecimal capitalInicial, BigDecimal objetivoMonetario
    ) {
        super(email, nome, sobrenome, senha, capitalInicial, objetivoMonetario);
    }

    @Override
    public void getResumo() {
        System.out.println("[FREE] " + getNome() + " " + getSobrenome() + " - (" + getEmail() + ")");
    }

    @Override
    public void getCotacao() {
        System.out.println(ERRO_PREMIUM);
    }

    @Override
    public void getGrafico() {
        System.out.println(ERRO_PREMIUM);
    }

}
