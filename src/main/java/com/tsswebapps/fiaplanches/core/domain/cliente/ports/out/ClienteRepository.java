package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;


import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteCadastrado> informarClientePorCpf(String cpf);
    Optional<ClienteCadastrado> informarClientePorEmail(String email);
    ClienteCadastrado salvar(Cliente cliente);
    void apagar(Long codigo);
    Optional<ClienteCadastrado> informarClientePorCodigo(Long codigo);
}
