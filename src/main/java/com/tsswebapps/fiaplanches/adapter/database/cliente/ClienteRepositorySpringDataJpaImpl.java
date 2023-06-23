package com.tsswebapps.fiaplanches.adapter.database.cliente;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.adapter.database.cliente.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.database.cliente.repository.SpringDataJPARepository;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public ClienteCadastrado salvar(Cliente cliente) {
        var clienteEntity = repository.save(mapper.toClienteEntity(cliente));
        return mapper.toClienteCadastrado(clienteEntity);
    }

    @Override
    public void apagar(Long codigo) {
        repository.deleteById(codigo);
    }

    @Override
    public List<ClienteCadastrado> listarTodos() {
        return null;
    }

    @Override
    public Optional<ClienteCadastrado> informarClientePorCodigo(Long codigo) {
        Optional<ClienteEntity> entityOptional = repository.findById(codigo);
        return entityOptional.map(mapper::toClienteCadastrado).or(Optional::empty);
    }
}
