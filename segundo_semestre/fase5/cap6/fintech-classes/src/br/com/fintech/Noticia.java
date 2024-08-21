package br.com.fintech;

public class Noticia {

    private Usuario autor;
    private String titulo;
    private String texto;

    public Noticia() {
    }

    public Noticia(Usuario autor, String titulo, String texto) {
        this.autor = autor;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Noticia setAutor(Usuario autor) {
        this.autor = autor;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Noticia setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getTexto() {
        return texto;
    }

    public Noticia setTexto(String texto) {
        this.texto = texto;
        return this;
    }

    @Override
    public String toString() {
        return "Noticias{" +
               "autor=" + autor.getId() +
               ", titulo='" + titulo + '\'' +
               ", texto='" + texto + '\'' +
               '}';
    }

}
