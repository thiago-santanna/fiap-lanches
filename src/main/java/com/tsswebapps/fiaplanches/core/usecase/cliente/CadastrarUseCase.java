package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;

public class CadastrarUseCase implements CadastrarClientePort {

    private  final ClienteRepository repository;

    public CadastrarUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(Cliente cliente) {
        return repository.salvar(cliente);
    }
}
