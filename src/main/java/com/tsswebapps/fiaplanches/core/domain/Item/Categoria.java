package com.tsswebapps.fiaplanches.core.domain.Item;

import javax.validation.constraints.NotBlank;

public record Categoria(
        Long id,
        @NotBlank(message = "Categoria deve ser informada")
        String descricao
) {
}
