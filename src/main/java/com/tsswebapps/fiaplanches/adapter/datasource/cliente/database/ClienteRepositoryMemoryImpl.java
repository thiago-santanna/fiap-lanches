package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.ClienteRepository;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;

import java.util.Optional;

public class ClienteRepositoryMemoryImpl implements ClienteRepository {
    @Override
    public Optional<ClienteCadastrado> InformarClientePorCpf(String cpf) {
        return null;
    }

    @Override
    public ClienteCadastrado CadastrarClienteDadosBasico(ClienteEntity cliente) {
        return null;
    }
}
