package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.ClienteRepository;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.repository.SpringDataJPARepository;
import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositorySpringDataJpaImpl implements ClienteRepository {

    private final SpringDataJPARepository repository;
    private final ClienteMapper mapper;

    public ClienteRepositorySpringDataJpaImpl(SpringDataJPARepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ClienteCadastrado> InformarClientePorCpf(String cpf) {
        return null;
    }

    @Override
    public ClienteCadastrado CadastrarClienteDadosBasico(ClienteEntity cliente) {
        var clienteEntity = repository.save(cliente);
        return mapper.toClienteCadastrado(clienteEntity);
    }
}
