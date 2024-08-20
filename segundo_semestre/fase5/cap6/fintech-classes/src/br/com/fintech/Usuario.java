package br.com.fintech;

import java.util.Objects;
import java.util.Random;

public class Usuario {

    private Integer id;
    private String username;
    private String password;
    private String primeiroNome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String cpf;

    public Usuario() {
        Random random = new Random();
        this.id = random.nextInt(10) + 1;
    }

    public Usuario(
            String username, String password, String primeiroNome,
            String sobrenome, String email, String telefone, String cpf
    ) {
        Random random = new Random();
        this.id = random.nextInt(10) + 1;

        this.username = username;
        this.password = password;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Usuario setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Usuario setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public Usuario setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Usuario setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario setCpf(String cpf) {
        if (isCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("ERRO: CPF inválido. Dica: use '000.000.000-00' para testes.\n");
        }
        return this;
    }

    public static boolean isCPF(String cpf) {
        // CPF fictício válido para testes durante desenvolvimento.
        if (Objects.equals(cpf, "000.000.000-00")) {
            return true;
        }

        cpf = cpf.replaceAll("\\D", "");


        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] multiplicador1 = new int[9];
        int[] multiplicador2 = new int[10];
        int soma;
        int resto;

        for (int i = 0; i < 9; i++) {
            multiplicador1[i] = 10 - i;
        }

        for (int i = 0; i < 10; i++) {
            multiplicador2[i] = 11 - i;
        }

        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * multiplicador1[i];
        }
        resto = soma % 11;
        if (resto < 2) {
            resto = 0;
        } else {
            resto = 11 - resto;
        }
        if (resto != Integer.parseInt(String.valueOf(cpf.charAt(9)))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * multiplicador2[i];
        }
        resto = soma % 11;
        if (resto < 2) {
            resto = 0;
        } else {
            resto = 11 - resto;
        }
        if (resto != Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", primeiroNome='" + primeiroNome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", email='" + email + '\'' +
               ", telefone='" + telefone + '\'' +
               ", cpf='" + cpf + '\'' +
               '}';
    }
}