package com.kauabiscotto.DeliveryApp;

public class PagamentoPix implements Pagamento {

    @Override
    public void pagar(double valor){
        System.out.println("Pagamento de R$" + valor + " realizado via Pix.");
    }

}
