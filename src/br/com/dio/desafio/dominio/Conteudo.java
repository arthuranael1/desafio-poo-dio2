package br.com.dio.desafio.dominio;

/**
 * Classe abstrata que representa um Conteúdo no Bootcamp.
 * Define atributos comuns como título e descrição, e um método abstrato para calcular XP.
 */
public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;

    protected String titulo;
    protected String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
