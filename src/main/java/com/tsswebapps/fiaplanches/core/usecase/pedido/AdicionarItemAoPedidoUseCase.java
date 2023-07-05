package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoRequest;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.AdicionarItemAoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class AdicionarItemAoPedidoUseCase implements AdicionarItemAoPedidoPort {
    private final PedidoRepository repository;

    public AdicionarItemAoPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemPedidoResponse executar(String comanda, ItemPedidoRequest itemPedido) {
        // validar se existe comanda,

        //validar se existe item

        var pedido = new ItemPedido(new Item(itemPedido.referenciaFabricante()), itemPedido.quantidade());
        return repository.adicionarItemAopedido(comanda, pedido);
    }
}
