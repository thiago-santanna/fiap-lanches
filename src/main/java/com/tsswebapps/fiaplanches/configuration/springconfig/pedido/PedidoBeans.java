package com.tsswebapps.fiaplanches.configuration.springconfig.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.*;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PagarPedidoIntegracaoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;
import com.tsswebapps.fiaplanches.core.usecase.pedido.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PedidoBeans {

    @Bean
    public CriarPedidoPort criarPedidoPort(PedidoRepository repository) {
        return new CriarPedidoUseCase(repository);
    }
    @Bean
    public AdicionarItemAoPedidoPort adicionarItemAoPedidoPort(PedidoRepository repository) {
        return new AdicionarItemAoPedidoUseCase(repository);
    }
    @Bean
    public RemoveItemDoPedidoPort removeItemDoPedidoPort(PedidoRepository repository) {
        return new RemoveItemDoPedidoUseCase(repository);
    }
    @Bean
    public ConfirmarPedidoPort confirmarPedidoPort(PedidoRepository repository) {
        return new ConfirmarPedidoUseCase(repository);
    }
    @Bean
    public PagarPedidoPort pagarPedidoPort(PedidoRepository repository, PagarPedidoIntegracaoPort integracaoPort) {
        return new PagarPedidoUseCase(repository, integracaoPort);
    }
}
