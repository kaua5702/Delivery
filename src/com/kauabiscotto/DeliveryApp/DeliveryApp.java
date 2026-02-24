package com.kauabiscotto.DeliveryApp;

import java.util.Scanner;

public class DeliveryApp {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro do Cliente ===");
        System.out.println("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite o endereço do cliente: ");
        String enderecoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(idCliente, nomeCliente, enderecoCliente);

        System.out.println("\n=== Criando Pedido ===");
        System.out.println("Digite o ID do pedido: ");
        int idPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = new Pedido(idPedido);
        pedido.setCliente(cliente);

        System.out.println("\n=== Adicionando Produtos ===");
        String continuar;
        do {
            System.out.println("Nome do produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.println("Preço do produto: ");
            double precoPorduto = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Categoria do produto: ");
            String categoriaProduto = scanner.nextLine();

            Produto produto = new Produto(nomeProduto, precoPorduto, categoriaProduto);
            pedido.adicionarProduto(produto);

            System.out.println("Deseja adicionar outro produto? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\n=== Forma de Pagamento ===");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartão");
        System.out.println("3 - Dinheiro");
        System.out.println("4 - Banco");
        System.out.println("Escolha a forma de pagamento: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> pedido.setPagamento(new PagamentoPix());
            case 2 -> pedido.setPagamento(new PagamentoCartao());
            case 3 -> pedido.setPagamento(new PagamentoDinheiro());
            case 4 -> pedido.setPagamento(new PagamentoBanco());
            default -> System.out.println("Opção inválida!");
        }

        System.out.println("\n--- Pedido antes da finalização ---");
        Thread.sleep(2000);

        pedido.finalizarPedido();

        System.out.println("\nGerando resumo do pedido...");
        Thread.sleep(2000);

        System.out.println("\n--- Pedido após finalização ---");
        System.out.println(pedido);

        scanner.close();
    }
}
