package com.tsswebapps.fiaplanches.adapter.datasource.cliente.database;

import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.repository.SpringDataJPARepository;
import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositorySpringDataJpaImpl implements ClienteRepository {

    private final SpringDataJPARepository repository;
    private final ClienteMapper mapper;

    public ClienteRepositorySpringDataJpaImpl(SpringDataJPARepository repository, @Qualifier("clienteMapperImpl") ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ClienteCadastrado> informarClientePorCpf(String cpf) {
        Optional<ClienteEntity> entityOptional = repository.findByCpf(cpf);
        return entityOptional.map(mapper::toClienteCadastrado).or(Optional::empty);
    }

    @Override
    public ClienteCadastrado cadastrar(ClienteRequest cliente) {
        var clienteEntity = repository.save(mapper.toClienteEntity(cliente));
        return mapper.toClienteCadastrado(clienteEntity);
    }
}
