package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;

public class CadastrarUseCase implements CadastrarPort {

    private  final ClienteRepository repository;

    public CadastrarUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(Cliente cliente) {
        return repository.cadastrar(cliente);
    }
}
