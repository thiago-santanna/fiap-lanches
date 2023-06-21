package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;

import java.util.Optional;

public interface BuscarClientePorCpf {
    Optional<ClienteCadastrado> executar(String cpf);
}
