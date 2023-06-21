package com.tsswebapps.fiaplanches.core.usecase.cliente.dto;

import javax.validation.constraints.NotBlank;

public record ClienteRequest(
        @NotBlank(message = "Nome do cliente deve ser informado")
        String nome,
        @NotBlank(message = "E-mail do cliente deve ser informado")
        String email,
        @NotBlank(message = "CPF do cliente deve ser informado")
        String cpf
) {}
