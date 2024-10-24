package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class UsuarioInfo {

    private int idUsuario;
    private LocalDate dataRegistro;
    private char emailVerificado;
    private char enviarNovidades;
    private String pronomes;
    private String apelido;

    public UsuarioInfo() {
    }

    public UsuarioInfo(
            int idUsuario, LocalDate dataRegistro, char emailVerificado,
            char enviarNovidades, String pronomes, String apelido
    ) {
        this.idUsuario = idUsuario;
        this.dataRegistro = dataRegistro;
        this.emailVerificado = emailVerificado;
        this.enviarNovidades = enviarNovidades;
        this.pronomes = pronomes;
        this.apelido = apelido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public char getEmailVerificado() {
        return emailVerificado;
    }

    public void setEmailVerificado(char emailVerificado) {
        this.emailVerificado = emailVerificado;
    }

    public char getEnviarNovidades() {
        return enviarNovidades;
    }

    public void setEnviarNovidades(char enviarNovidades) {
        this.enviarNovidades = enviarNovidades;
    }

    public String getPronomes() {
        return pronomes;
    }

    public void setPronomes(String pronomes) {
        this.pronomes = pronomes;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "UsuarioInfo{" +
               "idUsuario=" + idUsuario +
               ", dataRegistro=" + dataRegistro +
               ", emailVerificado=" + emailVerificado +
               ", enviarNovidades=" + enviarNovidades +
               ", pronomes='" + pronomes + '\'' +
               ", apelido='" + apelido + '\'' +
               '}';
    }

}
