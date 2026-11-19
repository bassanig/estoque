package br.com.estoque;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private int quantidade;

    protected Produto() {
    }

    public Produto(String titulo, Categoria categoria, int quantidade) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
}
