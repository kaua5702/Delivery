package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    public void salvar(Pedido pedido) {
        String sql = "INSERT INTO Pedido (id, cliente_id, status) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, pedido.getCliente().getId());
            stmt.setString(3, pedido.getStatus());
            stmt.executeUpdate();
            System.out.println("Pedido salvo no banco!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pedido buscarPorId(int id) {
        String sql = "SELECT * FROM Pedido WHERE id = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.buscarPorId(rs.getInt("cliente_id"));
                return new Pedido(rs.getInt("id"), cliente, rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void listarTodos() {
        String sql = "SELECT * FROM Pedido";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Lista de Pedidos ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Cliente ID: " + rs.getInt("cliente_id") +
                        " | Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}