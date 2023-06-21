package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Optional<ClienteCadastrado> informarClientePorCpf(String cpf);
    ClienteCadastrado salvar(Cliente cliente);
    void apagar(UUID codigo);
    List<ClienteCadastrado> listarTodos();
    Optional<ClienteCadastrado> informarClientePorCodigo(UUID codigo);
}
