package com.tsswebapps.fiaplanches.core.domain.Item;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record CategoriaCadastrado(
        @JsonProperty("categoria_id")
        Long id,
        @NotBlank(message = "Categoria deve ser informada")
        String descricao
) {
}
