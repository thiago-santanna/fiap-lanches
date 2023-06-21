package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.BuscarClientePorCpf;

public class AcessarPorCpfUseCase implements AcessarPorCpfPort {

    private final BuscarClientePorCpf clientePorCpf;

    public AcessarPorCpfUseCase(BuscarClientePorCpf clientePorCpf) {
        this.clientePorCpf = clientePorCpf;
    }

    @Override
    public ClienteCadastrado executar(String cpf) {
        var clienteCadastrado = clientePorCpf.executar(cpf);
        return null;
    }
}
