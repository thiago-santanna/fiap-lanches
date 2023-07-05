package com.tsswebapps.fiaplanches.core.domain.pedido.ports.out;

import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoCriadoResponse;

public interface PedidoRepository {
    PedidoCriadoResponse criarPedido(Pedido pedido);
    ItemPedidoResponse adicionarItemAopedido(String comanda, ItemPedido pedidoItemAdicionado);
    void removerItemDoPedido(String comanda, String referenciaItem);
}
