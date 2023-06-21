package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastroSimplificadoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.CadastrarClienteSimplesPort;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;

public class CadastroSimplesUseCase implements CadastroSimplificadoPort {

    private final CadastrarClienteSimplesPort cadastrarClienteSimples;
    private final ClienteMapper mapper;

    public CadastroSimplesUseCase(CadastrarClienteSimplesPort cadastrarClienteSimples, ClienteMapper mapper) {
        this.cadastrarClienteSimples = cadastrarClienteSimples;
        this.mapper = mapper;
    }

    @Override
    public ClienteCadastrado executar(ClienteRequest clienteRequest) {
        Cliente cliente = mapper.toCliente(clienteRequest);
        return cadastrarClienteSimples.executar(cliente);
    }
}
