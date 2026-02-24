package com.kauabiscotto.DeliveryApp;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private List<Produto> listaProdutos;
    private String status;
    private Pagamento formaPagamento;

    public Pedido(int id) {
        this.id = id;
        this.listaProdutos = new ArrayList<>();
        this.status = "Em andamento";
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("Produto adicionado!");
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : listaProdutos) {
            total += produto.getPreco();
        }
        return total;
    }

    public void setPagamento(Pagamento pagamento) {
        this.formaPagamento = pagamento;
        System.out.println("forma de pagamento definida!");
    }

    public void finalizarPedido() {
        double total = calcularTotal();
        if (formaPagamento != null) {
            formaPagamento.pagar(total);
        } else {
            System.out.println("A forma de pagamento não foi definida");
        }

        status = "Finalizado";
        System.out.println("Pedido concluído!");
    }

    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        System.out.println("Cliente associado ao pedido!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        sb.append("Status: ").append(status).append("\n");
        if (cliente != null) {
            sb.append("Cliente: ").append(cliente.getNome())
                    .append(" | Endereço: ").append(cliente.getEndereco()).append("\n");
        }
        sb.append("Produtos:\n");
        for (Produto produto : listaProdutos) {
            sb.append(" -").append(produto.getNome())
                    .append(" | R$").append(produto.getPreco()).append("\n");
        }
        sb.append("Total: R$").append(calcularTotal()).append("\n");
        return sb.toString();
    }


}
