package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteCadastrado> informarClientePorCpf(String cpf);
    ClienteCadastrado salvar(Cliente cliente);
    void apagar(Long codigo);
    List<ClienteCadastrado> listarTodos();
    Optional<ClienteCadastrado> informarClientePorCodigo(Long codigo);
}
