package com.kauabiscotto.DeliveryApp;

public class PagamentoBanco implements Pagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via Transferência Bancária.");
    }
}
