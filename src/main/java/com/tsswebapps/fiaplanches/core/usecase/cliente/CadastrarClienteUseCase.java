package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class CadastrarClienteUseCase implements CadastrarClientePort {

    private  final ClienteRepository repository;

    public CadastrarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(Cliente cliente) {
        if (repository.informarClientePorEmail(cliente.getEmail()).isPresent() ||
                repository.informarClientePorCpf(cliente.getCpf()).isPresent()) {
            throw new ApplicationException(TipoExcecao.RECURSO_DUPLICADO);
        }
        return repository.salvar(cliente);
    }
}
