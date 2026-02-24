package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO Produto (nome, preco, categoria) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getCategoria());
            stmt.executeUpdate();
            System.out.println("Produto salvo no banco!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("categoria")
                );
                produto.setId(rs.getInt("id"));
                return produto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listarTodos() {
        String sql = "SELECT * FROM Produto";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Lista de Produtos ===");
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