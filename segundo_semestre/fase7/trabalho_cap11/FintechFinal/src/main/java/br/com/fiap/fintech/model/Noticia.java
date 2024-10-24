package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Noticia {

    private int idNoticia;
    private int idUsuario;
    private LocalDate dataPublicacao;
    private String titulo;
    private String texto;

    public Noticia() {
    }

    public Noticia(int idUsuario, LocalDate dataPublicacao, String titulo, String texto) {
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Noticia{" +
               "idNoticia=" + idNoticia +
               ", idUsuario=" + idUsuario +
               ", dataPublicacao=" + dataPublicacao +
               ", titulo='" + titulo + '\'' +
               '}';
    }

}
