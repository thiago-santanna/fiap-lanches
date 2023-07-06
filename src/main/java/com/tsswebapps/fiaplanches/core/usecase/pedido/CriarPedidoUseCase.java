package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoCriadoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.SituacaoPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.CriarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class CriarPedidoUseCase implements CriarPedidoPort {
    private final PedidoRepository repository;

    public CriarPedidoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public PedidoCriadoResponse executar(String cpf) {
        Pedido pedido = new Pedido();
        pedido.setSituacaoPedido(SituacaoPedido.PENDENTE);
        if(cpf != null && !cpf.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(cpf);
            pedido.setCliente(cliente);
        }
        return repository.criarPedido(pedido);
    }
}
