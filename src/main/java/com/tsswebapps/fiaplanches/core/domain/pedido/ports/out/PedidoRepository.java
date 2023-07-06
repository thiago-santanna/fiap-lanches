package com.tsswebapps.fiaplanches.core.domain.pedido.ports.out;

import com.tsswebapps.fiaplanches.core.domain.pedido.*;

public interface PedidoRepository {
    PedidoCriadoResponse criarPedido(Pedido pedido);
    ItemPedidoResponse adicionarItemAopedido(String comanda, ItemPedido pedidoItemAdicionado);
    void removerItemDoPedido(String comanda, String referenciaItem);
    void confirmarPedido(String comanda);
    void confirmarPagamentoPedido(String comanda);
    Pedido getPedido(String comanda);
    void finalizarPedido(String comanda);
    void entregarPedido(String comanda);
    AndamentoPedido checarAndamentoPedido(String comanda);
}
