package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class AcessarPorCpfUseCase implements AcessarPorCpfPort {
    private  final ClienteRepository repository;

    public AcessarPorCpfUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(String cpf) {
        if(cpf == null || cpf.isEmpty()) {
            throw new ApplicationException(TipoExcecao.CPF_DEVE_SER_INFORMADO);
        }
        return repository.informarClientePorCpf(cpf).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
    }
}
