package com.kauabiscotto.DeliveryApp;

public class TesteProduto {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto(0, "Pizza Calabresa", 39.90, "Pizza");
        produtoDAO.salvar(produto);

        produtoDAO.listarTodos();
    }
}