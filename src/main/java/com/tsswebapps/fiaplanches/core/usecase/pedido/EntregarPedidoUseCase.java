package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.EntregarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class EntregarPedidoUseCase implements EntregarPedidoPort {

    private final PedidoRepository repository;

    public EntregarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(String comanda) {
        repository.entregarPedido(comanda);
    }
}
