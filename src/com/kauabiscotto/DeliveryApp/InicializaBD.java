package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializaBD {
    public static void main(String[] args) {
        try (Connection conn = ConexaoBD.conectar();
             Statement stmt = conn.createStatement()) {

            // Criar tabela Cliente
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Cliente (
                    id INTEGER PRIMARY KEY,
                    nome TEXT NOT NULL,
                    endereco TEXT NOT NULL
                );
            """);

            // Criar tabela Produto
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Produto (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    preco REAL NOT NULL,
                    categoria TEXT
                );
            """);

            // Criar tabela Pedido
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Pedido (
                    id INTEGER PRIMARY KEY,
                    cliente_id INTEGER NOT NULL,
                    status TEXT NOT NULL,
                    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
                );
            """);

            // Criar tabela PedidoProduto
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS PedidoProduto (
                    pedido_id INTEGER NOT NULL,
                    produto_id INTEGER NOT NULL,
                    FOREIGN KEY (pedido_id) REFERENCES Pedido(id),
                    FOREIGN KEY (produto_id) REFERENCES Produto(id)
                );
            """);

            // Criar tabela Pagamento
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Pagamento (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    pedido_id INTEGER NOT NULL,
                    tipo TEXT NOT NULL,
                    valor REAL NOT NULL,
                    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)
                );
            """);

            System.out.println("Todas as tabelas foram criadas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}