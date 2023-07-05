package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.RemoveItemDoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class RemoveItemDoPedidoUseCase implements RemoveItemDoPedidoPort {
    private final PedidoRepository repository;

    public RemoveItemDoPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(String comanda, String referenciaItem) {
        repository.removerItemDoPedido(comanda, referenciaItem);
    }
}
