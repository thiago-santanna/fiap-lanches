package com.tsswebapps.fiaplanches.core.domain.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public record ItemAlterar(
        @NotBlank(message = "A referencia do fabricante é obrigatória.")
        String referenciaFabricante,
        @NotBlank(message = "A nome do item deve ser informado.")
        String nome,
        @NotBlank(message = "A descrição do item deve ser informado.")
        String descricao,
        @Positive(message = "O valor do item deve ser informado")
        BigDecimal valor
) {}
