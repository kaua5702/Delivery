package com.kauabiscotto.DeliveryApp;

public class Cliente {

    private int id;
    private String nome;
    private String endereco;

    public Cliente(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + id + "\nNome: " + nome + "\nEndereço: " + endereco;
    }
}
