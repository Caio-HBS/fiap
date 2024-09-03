package br.com.fintech.Usuario;

import java.math.BigDecimal;

public class UsuarioFree extends Usuario {

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
        System.out.println(
                "ERRO: Esse recurso só está disponível para usuários premium,\n" +
                "acesse https://fintech.com/assinar-premium para mais informações."
        );
    }

}
