package com.tsswebapps.fiaplanches.configuration.springconfig.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.CriarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;
import com.tsswebapps.fiaplanches.core.usecase.pedido.CriarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PedidoBeans {

    @Bean
    public CriarPedidoPort criarPedidoPort(PedidoRepository repository) {
        return new CriarPedidoUseCase(repository);
    }
}
