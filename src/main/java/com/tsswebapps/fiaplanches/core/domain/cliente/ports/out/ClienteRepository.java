package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteCadastrado> informarClientePorCpf(String cpf);
    ClienteCadastrado cadastrar(ClienteRequest cliente);
}
