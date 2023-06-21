package com.tsswebapps.fiaplanches.adapter.datasource.cliente;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.CadastrarClienteSimplesPort;
import org.springframework.stereotype.Component;

@Component
public class CadastrarClienteSimplesImpl implements CadastrarClienteSimplesPort {
    private  final ClienteRepository repository;
    private final ClienteMapper mapper;

    public CadastrarClienteSimplesImpl(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClienteCadastrado executar(Cliente cliente) {
        var clienteEntity = mapper.toClienteEntity(cliente);
        return repository.CadastrarClienteDadosBasico(clienteEntity);
    }
}
