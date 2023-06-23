package com.tsswebapps.fiaplanches.core.domain.cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public record Cliente (
        Long id,
        @NotBlank(message = "Nome do cliente deve ser informado")
        String nome,
        @NotBlank(message = "E-mail do cliente deve ser informado")
        @Email
        String email,
        @NotBlank(message = "CPF do cliente deve ser informado")
        String cpf
) {}
