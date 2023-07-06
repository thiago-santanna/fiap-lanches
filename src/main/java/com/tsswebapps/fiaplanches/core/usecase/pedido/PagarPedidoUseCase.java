package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.PagamentoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoPagar;
import com.tsswebapps.fiaplanches.core.domain.pedido.SituacaoPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.PagarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PagarPedidoIntegracaoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

public class PagarPedidoUseCase implements PagarPedidoPort {
    private final PedidoRepository repository;
    private final PagarPedidoIntegracaoPort pagarPedidoIntegracaoPort;

    public PagarPedidoUseCase(PedidoRepository repository, PagarPedidoIntegracaoPort pagarPedidoIntegracaoPort) {
        this.repository = repository;
        this.pagarPedidoIntegracaoPort = pagarPedidoIntegracaoPort;
    }

    @Override
    public PagamentoResponse executar(String comanda) {
        Pedido pedido = repository.getPedido(comanda);
        var pagamentoResponse = pagarPedidoIntegracaoPort.executar(new PedidoPagar(comanda, pedido.getValorTotal()));
        repository.confirmarPagamentoPedido(comanda);
        pagamentoResponse.setSituacaoPedido(SituacaoPedido.EM_PREPARACAO.toString());
        pagamentoResponse.setObservacao("Cozinha Recebeu!");
        return pagamentoResponse;
    }
}
