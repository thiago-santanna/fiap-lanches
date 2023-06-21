package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastroSimplificadoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.CadastrarClienteSimplesPort;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;
import org.springframework.beans.factory.annotation.Qualifier;

public class CadastroSimplesUseCase implements CadastroSimplificadoPort {

    private final CadastrarClienteSimplesPort cadastrarClienteSimples;
    private final ClienteMapper mapper;

    public CadastroSimplesUseCase(CadastrarClienteSimplesPort cadastrarClienteSimples, @Qualifier("clienteMapperImpl") ClienteMapper mapper) {
        this.cadastrarClienteSimples = cadastrarClienteSimples;
        this.mapper = mapper;
    }

    @Override
    public ClienteCadastrado executar(ClienteRequest clienteRequest) {
        Cliente cliente = mapper.toCliente(clienteRequest);
        return cadastrarClienteSimples.executar(cliente);
    }
}
