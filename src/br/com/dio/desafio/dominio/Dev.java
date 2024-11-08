package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Representa um desenvolvedor inscrito no Bootcamp.
 * O Dev possui uma lista de conteúdos inscritos e concluídos, e um método para calcular o XP total.
 */
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        double soma = 0;
        for (Conteudo conteudo : conteudosConcluidos) {
            soma += conteudo.calcularXp();
        }
        return soma;
    }

    public void mostrarProgresso() {
        System.out.println("Nome: " + nome);
        System.out.println("Conteúdos Inscritos: " + conteudosInscritos);
        System.out.println("Conteúdos Concluídos: " + conteudosConcluidos);
        System.out.println("XP Total: " + calcularTotalXp());
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
}
