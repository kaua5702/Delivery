package com.kauabiscotto.DeliveryApp;

public class Produto {

    private String nome;
    private Double preco;
    private String categoria;


    public Produto(String nome, Double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                " | Preço: R$" + preco +
                " | Categoria: " + categoria;
    }

}
