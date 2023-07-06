package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

import com.tsswebapps.fiaplanches.core.domain.pedido.PagamentoResponse;

public interface PagarPedidoPort {
    PagamentoResponse executar(String comanda);
}
