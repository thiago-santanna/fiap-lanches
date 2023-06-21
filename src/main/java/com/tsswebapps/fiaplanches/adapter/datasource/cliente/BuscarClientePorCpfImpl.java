package com.tsswebapps.fiaplanches.adapter.datasource.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.BuscarClientePorCpf;

import java.util.Optional;

public class BuscarClientePorCpfImpl implements BuscarClientePorCpf {

    private ClienteRepository repository;

    @Override
    public Optional<ClienteCadastrado> executar(String cpf) {
        repository.InformarClientePorCpf(cpf);
        return null;
    }
}
