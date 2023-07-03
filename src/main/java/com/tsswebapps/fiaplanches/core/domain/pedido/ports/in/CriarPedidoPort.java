package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.PedidoCriadoResponse;

public interface CriarPedidoPort {
    PedidoCriadoResponse executar(String cpf);
}
