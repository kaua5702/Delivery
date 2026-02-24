package com.kauabiscotto.DeliveryApp;

public class TesteBD {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(1, "Kauã Biscotto", "Rua das Flores, 123");
        clienteDAO.salvar(cliente);

        Cliente clienteBuscado = clienteDAO.buscarPorId(1);
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNome() +
                    " | Endereço: " + clienteBuscado.getEndereco());
        }

        clienteDAO.listarTodos();
    }

}

