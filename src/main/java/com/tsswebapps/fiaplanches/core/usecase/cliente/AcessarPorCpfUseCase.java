package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.BuscarClientePorCpf;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class AcessarPorCpfUseCase implements AcessarPorCpfPort {

    private final BuscarClientePorCpf buscarClientePorCpf;

    public AcessarPorCpfUseCase(BuscarClientePorCpf clientePorCpf) {
        this.buscarClientePorCpf = clientePorCpf;
    }

    @Override
    public ClienteCadastrado executar(String cpf) {
        if(cpf == null || cpf.isEmpty()) {
            throw new ApplicationException(TipoExcecao.CPF_DEVE_SER_INFORMADO);
        }
        return buscarClientePorCpf.executar(cpf);
    }
}
