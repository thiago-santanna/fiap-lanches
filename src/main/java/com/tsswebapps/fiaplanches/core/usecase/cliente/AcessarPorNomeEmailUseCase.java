package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteLogin;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarNomeEmailPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class AcessarPorNomeEmailUseCase implements AcessarNomeEmailPort {

    private final ClienteRepository repository;

    public AcessarPorNomeEmailUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(ClienteLogin cliente) {
        return repository.informarClientePorNomeEmail(cliente).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO)
        );
    }
}
