package br.com.fiap.fintech.model;

import br.com.fiap.fintech.util.CriptografiaUtils;

import java.time.LocalDate;

public class Usuario {

    private int idUsuario;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private String nomeUsuario;
    private String senha;
    private String cargo;

    public Usuario() {
    }

    public Usuario(
            String nome, String sobrenome, LocalDate dataNascimento, String email,
            String nomeUsuario, String senha, String cargo
    ) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        setSenha(senha);
        this.cargo = cargo;
    }

    public Usuario(
            int idUsuario, String nome, String sobrenome, LocalDate dataNascimento,
            String email, String nomeUsuario, String senha, String cargo
    ) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        setSenha(senha);
        this.cargo = cargo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "idUsuario=" + idUsuario +
               ", nome='" + nome + '\'' +
               ", sobrenome='" + sobrenome + '\'' +
               ", dataNascimento=" + dataNascimento +
               ", email='" + email + '\'' +
               ", nomeUsuario='" + nomeUsuario + '\'' +
               ", cargo='" + cargo + '\'' +
               '}';
    }
}
