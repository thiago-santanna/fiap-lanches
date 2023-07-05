package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoCriadoResponse;

public interface CriarPedidoPort {
    PedidoCriadoResponse executar(String cpf);
}
