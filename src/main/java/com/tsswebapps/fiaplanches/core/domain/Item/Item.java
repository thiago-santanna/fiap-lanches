package com.tsswebapps.fiaplanches.core.domain.Item;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public record Item (
        Long id,
        String referenciaFabricante,
        String nome,
        String descricao,
        BigDecimal valor,
        Categoria categoria,
        Set<Imagem> imagens
) {}
