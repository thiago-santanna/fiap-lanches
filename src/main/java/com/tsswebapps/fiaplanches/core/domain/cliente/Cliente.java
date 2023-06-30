package com.tsswebapps.fiaplanches.core.domain.cliente;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public record Cliente (
        Long id,
        @NotBlank(message = "Nome do cliente deve ser informado")
        String nome,
        @NotBlank(message = "E-mail do cliente deve ser informado")
        @Email
        String email,
        @NotBlank(message = "CPF do cliente deve ser informado")
        @Pattern(regexp = "^(\\d{3}\\.?){2}\\d{3}-?\\d{2}$", message = "CPF inválido, informe corretamente.")
        String cpf
) {}
