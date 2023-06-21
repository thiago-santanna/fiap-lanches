package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database;

import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;

import java.util.Optional;

public class ClienteRepositoryMemoryImpl implements ClienteRepository {
    @Override
    public Optional<ClienteCadastrado> informarClientePorCpf(String cpf) {

        return null;
    }

    @Override
    public ClienteCadastrado cadastrar(ClienteRequest cliente) {
        return null;
    }
}
