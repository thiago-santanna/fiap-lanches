package com.tsswebapps.fiaplanches.configuration.springconfig.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.AdicionarItemAoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.CriarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.RemoveItemDoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;
import com.tsswebapps.fiaplanches.core.usecase.pedido.AdicionarItemAoPedidoUseCase;
import com.tsswebapps.fiaplanches.core.usecase.pedido.CriarPedidoUseCase;
import com.tsswebapps.fiaplanches.core.usecase.pedido.RemoveItemDoPedidoUseCase;
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
}
