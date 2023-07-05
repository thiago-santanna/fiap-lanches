package com.tsswebapps.fiaplanches.core.domain.pedido;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        String referencia,
        String nome,
        String descricao,
        BigDecimal valor) {
}
