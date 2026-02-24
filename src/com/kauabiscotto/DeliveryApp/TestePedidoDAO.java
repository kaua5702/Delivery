package com.kauabiscotto.DeliveryApp;

public class TestePedidoDAO {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();

        // Criar cliente
        Cliente cliente = new Cliente(1, "Kauã Biscotto", "Rua das Flores, 123");
        clienteDAO.salvar(cliente);

        // Criar pedido
        Pedido pedido = new Pedido(1, cliente, "Em andamento");
        pedidoDAO.salvar(pedido);

        // Buscar pedido
        Pedido pedidoBuscado = pedidoDAO.buscarPorId(1);
        if (pedidoBuscado != null) {
            System.out.println("Pedido encontrado: ID " + pedidoBuscado.getId() +
                    " | Cliente: " + pedidoBuscado.getCliente().getNome() +
                    " | Status: " + pedidoBuscado.getStatus());
        }

        // Listar todos
        pedidoDAO.listarTodos();
    }
}