package com.tsswebapps.fiaplanches.core.domain.pedido;

public record ItemPedidoRequest(
        String referenciaFabricante,
        int quantidade
) {}
