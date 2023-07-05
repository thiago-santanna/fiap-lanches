package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoRequest;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoResponse;

public interface AdicionarItemAoPedidoPort {
    ItemPedidoResponse executar(String comanda, ItemPedidoRequest itemPedido);
}
