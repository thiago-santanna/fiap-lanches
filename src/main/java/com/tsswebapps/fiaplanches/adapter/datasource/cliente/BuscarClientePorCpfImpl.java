package com.tsswebapps.fiaplanches.adapter.datasource.cliente;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.BuscarClientePorCpf;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BuscarClientePorCpfImpl implements BuscarClientePorCpf {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public BuscarClientePorCpfImpl(ClienteRepository repository, @Qualifier("clienteMapperImpl") ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClienteCadastrado executar(String cpf) {
        var clienteEntity = repository.InformarClientePorCpf(cpf).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
        return mapper.toClienteCadastrado(clienteEntity);
    }
}
