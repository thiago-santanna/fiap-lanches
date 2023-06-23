package com.tsswebapps.fiaplanches.core.domain.cliente;

import java.util.Objects;
import java.util.UUID;

public record ClienteCadastrado (
        Long id,
        String nome,
        String email,
        String cpf
){}