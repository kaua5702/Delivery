package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO {

    public void salvar(Pagamento pagamento) {
        String sql = "INSERT INTO Pagamento (pedido_id, tipo, valor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getPedidoId());
            stmt.setString(2, pagamento.getTipo());
            stmt.setDouble(3, pagamento.getValor());
            stmt.executeUpdate();
            System.out.println("Pagamento registrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarTodos() {
        String sql = "SELECT * FROM Pagamento";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Lista de Pagamentos ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Pedido ID: " + rs.getInt("pedido_id") +
                        " | Tipo: " + rs.getString("tipo") +
                        " | Valor: " + rs.getDouble("valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}