package com.kauabiscotto.DeliveryApp;

public class PagamentoCartao implements Pagamento{

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Cartão.");
    }

}

