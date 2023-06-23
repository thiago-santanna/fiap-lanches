package com.tsswebapps.fiaplanches.core.domain.Item;

import java.math.BigDecimal;

public record ItemCadastrado(
        Long id,
        String referenciaFabricante,
        String nome,
        String descricao,
        BigDecimal valor,
        Categoria categoria
) {}
