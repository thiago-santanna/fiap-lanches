package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

import java.util.Optional;

public class ClienteRepositoryMemoryImpl implements ClienteRepository {
    @Override
    public Optional<ClienteCadastrado> informarClientePorCpf(String cpf) {

        return null;
    }

    @Override
    public ClienteCadastrado cadastrar(Cliente cliente) {
        return null;
    }
}
