package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

public interface RemoveItemDoPedidoPort {
    void executar(String comanda, String referenciaItem);
}
