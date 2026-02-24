package com.kauabiscotto.DeliveryApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:sqlite:delivery.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection conn = conectar()) {
            System.out.println("Conexão com SQLite realizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}