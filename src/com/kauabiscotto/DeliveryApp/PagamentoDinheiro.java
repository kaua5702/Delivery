package com.kauabiscotto.DeliveryApp;

public class PagamentoDinheiro implements Pagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado em Dinheiro.");
    }
}
