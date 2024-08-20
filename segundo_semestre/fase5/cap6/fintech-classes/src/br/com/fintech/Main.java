package br.com.fintech;

public class Main {
    public static void main(String[] args) {

        System.out.println("---Criar usuário com valores válidos---");
        Usuario usuario = new Usuario();
        usuario.setUsername("Caio-HBS").setPassword("senha-segura").setPrimeiroNome("Caio").setSobrenome("Bianchi")
                .setUsername("caiohbs").setEmail("@email.com").setTelefone("91234-5678").setCpf("000.000.000-00");

        System.out.println(usuario);

        System.out.println("\n---Testar validação de CPF (inválido)---");
        usuario.setCpf("123.456.789-01");

        Login login = new Login(usuario);
        System.out.println("---Realizar login com credenciais válidas---");
        login.doLogin("Caio-HBS", "senha-segura");

        System.out.println("---Realizar login com credenciais inválidas---");
        login.doLogin("Caio-HBS", "senha-errada");

    }
}