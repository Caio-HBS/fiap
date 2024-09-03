package br.com.fintech;

import br.com.fintech.Usuario.UsuarioFree;
import br.com.fintech.Usuario.UsuarioPremium;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BigDecimal valor1 = new BigDecimal("1.000");
        BigDecimal valor2 = new BigDecimal("10.000");
        BigDecimal valor3 = new BigDecimal("100.000");

        System.out.println("TESTES NOS USUÁRIOS");
        UsuarioFree usuario1 = new UsuarioFree(
                "joao-silva@email.com", "João", "Silva", "senha-segura", valor2, valor1
        );
        UsuarioPremium usuario2 = new UsuarioPremium(
                "joana-santos25@email.com", "Joana", "Santos", "senha-segura", valor1, valor3
        );

        System.out.println("---Resumo dos dois usuários---");
        usuario1.getResumo();
        usuario2.getResumo();

        System.out.println("\n---Cotação para cada usuário---");
        usuario1.getCotacao();
        System.out.println();
        usuario2.getCotacao();

        System.out.println("\n---Gráficos de lucro para cada usuário---");
        usuario1.getGrafico();
        System.out.println();
        usuario2.getGrafico();

        System.out.println("\n---Objetivo dos usuários---");
        usuario1.getObjetivo();
        System.out.println();
        usuario2.getObjetivo();


        System.out.println("\n");
        System.out.println("TESTES DOS INVESTIMENTOS");
    }
}