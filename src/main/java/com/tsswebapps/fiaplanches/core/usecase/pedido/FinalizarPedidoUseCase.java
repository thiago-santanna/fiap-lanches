package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.FinalizarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class FinalizarPedidoUseCase implements FinalizarPedidoPort {
    private final PedidoRepository repository;

    public FinalizarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(String comanda) {
        repository.finalizarPedido(comanda);
    }
}
