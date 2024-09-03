package br.com.fintech;

import br.com.fintech.Investimento.Investimento;
import br.com.fintech.Investimento.Poupanca;
import br.com.fintech.Investimento.RendaFixa;
import br.com.fintech.Servico.Servico;
import br.com.fintech.Servico.ServicoRecorrente;
import br.com.fintech.Servico.ServicoUnico;
import br.com.fintech.Usuario.Usuario;
import br.com.fintech.Usuario.UsuarioFree;
import br.com.fintech.Usuario.UsuarioPremium;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BigDecimal valor1 = new BigDecimal("1.000");
        BigDecimal valor2 = new BigDecimal("10.000");
        BigDecimal valor3 = new BigDecimal("100.000");

        System.out.println("TESTES NOS USUÁRIOS");
        Usuario usuarioFree = new UsuarioFree(
                "joao-silva@email.com", "João", "Silva", "senha-segura", valor2, valor1
        );
        Usuario usuarioPremium = new UsuarioPremium(
                "joana-santos25@email.com", "Joana", "Santos", "senha-segura", valor1, valor3
        );

        System.out.println("---Resumo dos dois usuários---");
        usuarioFree.getResumo();
        usuarioPremium.getResumo();

        System.out.println("\n---Cotação para cada usuário---");
        usuarioFree.getCotacao();
        System.out.println();
        usuarioPremium.getCotacao();

        System.out.println("\n---Objetivo dos usuários---");
        usuarioFree.getObjetivo();
        System.out.println();
        usuarioPremium.getObjetivo();


        System.out.println("\n");
        System.out.println("TESTES DOS INVESTIMENTOS");

        Investimento poupanca = new Poupanca(1000);
        String retornoPoupanca = poupanca.calcularRetorno(12);
        System.out.println("Retorno Poupança em 12 meses: R$ " + retornoPoupanca);

        Investimento rendaFixa = new RendaFixa(2000, 0.08, 0.15);
        String retornoRendaFixa = rendaFixa.calcularRetorno(5);
        System.out.print("Retorno Renda Fixa em 5 anos: R$ " + retornoRendaFixa);


        System.out.println("\n");
        System.out.println("TESTES DOS SERVIÇOS");

        Servico servicoUnic = new ServicoUnico("Jantar", "Jantar no restaurante chique", 231.97);
        Servico servicoRec = new ServicoRecorrente("Spotify", "Mensalidade do Spotify", 20.0, 30);

        servicoUnic.getResumo();
        servicoRec.getResumo();

    }
}