package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;

public class CadastrarUseCase implements CadastrarPort {

    private  final ClienteRepository repository;

    public CadastrarUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(ClienteRequest clienteRequest) {
        return repository.cadastrar(clienteRequest);
    }
}
