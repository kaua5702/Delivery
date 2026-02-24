package com.kauabiscotto.DeliveryApp;

public class Pedido {
    private int id;
    private Cliente cliente;
    private String status;

    public Pedido(int id, Cliente cliente, String status) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public String getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setStatus(String status) { this.status = status; }
}