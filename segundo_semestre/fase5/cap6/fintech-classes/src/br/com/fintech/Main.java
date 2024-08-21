package br.com.fintech;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("---Criar usuário com valores válidos---");
        Usuario usuario = new Usuario();
        usuario.setUsername("Caio-HBS")
                .setPassword("senha-segura").setPrimeiroNome("Caio").setSobrenome("Bianchi")
                .setEmail("@email.com").setTelefone("91234-5678").setCpf("000.000.000-00");
        System.out.println(usuario);


        System.out.println("\n---Testar validação de CPF (inválido)---");
        usuario.setCpf("123.456.789-01");


        Login login = new Login(usuario);
        System.out.println("---Realizar login com credenciais válidas---");
        login.doLogin("Caio-HBS", "senha-segura");


        System.out.println("---Realizar login com credenciais inválidas---");
        login.doLogin("Caio-HBS", "senha-errada");


        System.out.println("---Criar primeiro serviço---");
        LocalDate data1 = LocalDate.now().minusDays(20);

        Servico servico1 = new Servico();
        servico1.setItem("LIS Conta")
                .setDescricao("Pagamento referente ao LIS da conta bancária.")
                .setValorAoMes(3.50).setDataCadastro(data1);
        System.out.println(servico1);


        System.out.println("\n---Criar segundo serviço---");
        LocalDate data2 = LocalDate.now();

        Servico servico2 = new Servico();
        servico2.setItem("Seguro cartão")
                .setDescricao("Pagamento mensal do seguro do cartão.")
                .setValorAoMes(10.00).setDataCadastro(data2);
        System.out.println(servico2);


        System.out.println("\n---Cadastrar notícia no blog---");
        Noticia noticia = new Noticia();
        noticia.setAutor(usuario)
                .setTitulo("Aprenda a gerir suas finanças")
                .setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        System.out.println(noticia);


        System.out.println("\n---Cadastrar dados adicionais de usuário---");
        CadastroAdicional adicional = new CadastroAdicional();
        adicional.setUsuario(usuario)
                .setCapitalInicial(10.000).setReceberEmails(false).setContaAtivada(true).setPronomes("Ele/Dele")
                .setServicosCadastrados(servico1).setServicosCadastrados(servico2).setNoticias(noticia);
        System.out.println(adicional);

    }
}