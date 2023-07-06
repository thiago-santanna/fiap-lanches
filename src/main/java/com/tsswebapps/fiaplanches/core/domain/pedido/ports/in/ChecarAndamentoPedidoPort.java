package com.tsswebapps.fiaplanches.core.domain.pedido.ports.in;

import com.tsswebapps.fiaplanches.core.domain.pedido.AndamentoPedido;

public interface ChecarAndamentoPedidoPort {
    AndamentoPedido executar(String comanda);
}
