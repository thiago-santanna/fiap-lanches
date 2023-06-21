package com.tsswebapps.fiaplanches.core.usecase.cliente.dto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record ClienteRequest(
        UUID id,
        @NotBlank(message = "Nome do cliente deve ser informado")
        String nome,
        @NotBlank(message = "E-mail do cliente deve ser informado")
        String email,
        @NotBlank(message = "CPF do cliente deve ser informado")
        String cpf
) {}
