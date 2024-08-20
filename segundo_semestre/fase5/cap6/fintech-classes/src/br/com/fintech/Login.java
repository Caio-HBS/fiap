package br.com.fintech;

public class Login {

    private Usuario usuario;

    public Login(Usuario usuario) {
        this.usuario = usuario;
    }

    public void doLogin(String username, String password) {
        System.out.println("Realizando login para o usuário: " + "'" + username + "'\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
            System.out.println("Login realizado com sucesso!\n");
        } else {
            System.out.println("Falha no login, cheque as credenciais e tente novamente.\n");
        }
    }

}
