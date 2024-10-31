package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Noticia {

    private int idNoticia;
    private int idUsuario;
    private LocalDate dataPublicacao;
    private String titulo;
    private String texto;
    private String resumo;
    private String imagem;
    private String imagemAlt;

    public Noticia() {
    }

    public Noticia(
            int idUsuario, LocalDate dataPublicacao, String titulo, String texto,
            String resumo, String imagem, String imagemAlt
    ) {
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.texto = texto;
        this.resumo = resumo;
        this.imagem = imagem;
        this.imagemAlt = imagemAlt;
    }

    public Noticia(
            int idNoticia, int idUsuario, LocalDate dataPublicacao, String titulo,
            String texto, String resumo, String imagem, String imagemAlt
    ) {
        this.idNoticia = idNoticia;
        this.idUsuario = idUsuario;
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.texto = texto;
        this.resumo = resumo;
        this.imagem = imagem;
        this.imagemAlt = imagemAlt;
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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagemAlt() {
        return imagemAlt;
    }

    public void setImagemAlt(String imagemAlt) {
        this.imagemAlt = imagemAlt;
    }

    @Override
    public String toString() {
        return "Noticia{" +
               "idNoticia=" + idNoticia +
               ", idUsuario=" + idUsuario +
               ", dataPublicacao=" + dataPublicacao +
               ", titulo='" + titulo + '\'' +
               ", texto='" + texto + '\'' +
               ", resumo='" + resumo + '\'' +
               ", imagem='" + imagem + '\'' +
               ", imagemAlt='" + imagemAlt + '\'' +
               '}';
    }

}
