package com.tsswebapps.fiaplanches.core.domain.pedido.ports.out;

import com.tsswebapps.fiaplanches.core.domain.pedido.PagamentoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoPagar;

public interface PagarPedidoIntegracaoPort {
    PagamentoResponse executar(PedidoPagar pedidoPagar);
}
