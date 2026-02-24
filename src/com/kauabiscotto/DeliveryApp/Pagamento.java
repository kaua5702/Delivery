package com.kauabiscotto.DeliveryApp;

public class Pagamento {
    private int id;
    private int pedidoId;
    private String tipo;
    private double valor;

    // Construtor com ID (quando buscar do banco)
    public Pagamento(int id, int pedidoId, String tipo, double valor) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.tipo = tipo;
        this.valor = valor;
    }

    // Construtor sem ID (quando salvar novo pagamento)
    public Pagamento(int pedidoId, String tipo, double valor) {
        this.pedidoId = pedidoId;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getId() { return id; }
    public int getPedidoId() { return pedidoId; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }

    public void setId(int id) { this.id = id; }
    public void setPedidoId(int pedidoId) { this.pedidoId = pedidoId; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Pagamento{id=" + id + ", pedidoId=" + pedidoId +
                ", tipo='" + tipo + "', valor=" + valor + "}";
    }
}