package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.ConfirmarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class ConfirmarPedidoUseCase implements ConfirmarPedidoPort {
    private final PedidoRepository repository;

    public ConfirmarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(String comanda) {
        repository.confirmarPedido(comanda);
    }
}
