package com.kauabiscotto.DeliveryApp;

import java.util.Scanner;

public class DeliveryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
        PagamentoDAO pagamentoDAO = new PagamentoDAO();

        while (true) {
            System.out.println("\n=== MENU DELIVERY ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Criar Pedido");
            System.out.println("4 - Adicionar Produto ao Pedido");
            System.out.println("5 - Registrar Pagamento");
            System.out.println("6 - Listar Clientes");
            System.out.println("7 - Listar Produtos");
            System.out.println("8 - Listar Pedidos");
            System.out.println("9 - Listar Produtos de um Pedido");
            System.out.println("10 - Listar Pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID do cliente: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    Cliente cliente = new Cliente(id, nome, endereco);
                    clienteDAO.salvar(cliente);
                }
                case 2 -> {
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble(); sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    Produto produto = new Produto(nome, preco, categoria);
                    produtoDAO.salvar(produto);
                }
                case 3 -> {
                    System.out.print("ID do pedido: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("ID do cliente: ");
                    int clienteId = sc.nextInt(); sc.nextLine();
                    Cliente cliente = clienteDAO.buscarPorId(clienteId);
                    if (cliente != null) {
                        Pedido pedido = new Pedido(id, cliente, "Em andamento");
                        pedidoDAO.salvar(pedido);
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case 4 -> {
                    System.out.print("ID do pedido: ");
                    int pedidoId = sc.nextInt();
                    System.out.print("ID do produto: ");
                    int produtoId = sc.nextInt();
                    pedidoProdutoDAO.adicionarProdutoAoPedido(pedidoId, produtoId);
                }
                case 5 -> {
                    System.out.print("ID do pedido: ");
                    int pedidoId = sc.nextInt(); sc.nextLine();
                    System.out.print("Tipo de pagamento (Cartão/Pix/Dinheiro): ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    Pagamento pagamento = new Pagamento(pedidoId, tipo, valor);
                    pagamentoDAO.salvar(pagamento);
                }
                case 6 -> clienteDAO.listarTodos();
                case 7 -> produtoDAO.listarTodos();
                case 8 -> pedidoDAO.listarTodos();
                case 9 -> {
                    System.out.print("ID do pedido: ");
                    int pedidoId = sc.nextInt();
                    pedidoProdutoDAO.listarProdutosDoPedido(pedidoId);
                }
                case 10 -> pagamentoDAO.listarTodos();
                case 0 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}