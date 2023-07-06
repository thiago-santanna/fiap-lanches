package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.AndamentoPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.ChecarAndamentoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class ChecarAndamentoUseCase implements ChecarAndamentoPedidoPort {

    private final PedidoRepository repository;

    public ChecarAndamentoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }
    @Override
    public AndamentoPedido executar(String comanda) {
        return null;
    }
}
