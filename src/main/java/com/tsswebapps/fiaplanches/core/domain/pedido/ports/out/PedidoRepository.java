package com.tsswebapps.fiaplanches.core.domain.pedido.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.PedidoCriadoResponse;

public interface PedidoRepository {
    PedidoCriadoResponse criarPedido(Pedido pedido);
}
