package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoProdutoDAO {

    public void adicionarProdutoAoPedido(int pedidoId, int produtoId) {
        String sql = "INSERT INTO PedidoProduto (pedido_id, produto_id) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();
            System.out.println("Produto vinculado ao pedido!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProdutosDoPedido(int pedidoId) {
        String sql = """
            SELECT Produto.id, Produto.nome, Produto.preco, Produto.categoria
            FROM PedidoProduto
            INNER JOIN Produto ON PedidoProduto.produto_id = Produto.id
            WHERE PedidoProduto.pedido_id = ?
        """;
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("=== Produtos do Pedido " + pedidoId + " ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Nome: " + rs.getString("nome") +
                        " | Preço: " + rs.getDouble("preco") +
                        " | Categoria: " + rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}