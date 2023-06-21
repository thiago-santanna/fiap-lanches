package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.BuscarClientePorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;


public class BuscarClientePorCodigoUseCase implements BuscarClientePorCodigoPort {

    private  final ClienteRepository repository;

    public BuscarClientePorCodigoUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteCadastrado executar(Long codigo) {
        if(codigo == null || codigo.toString().isEmpty()) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }
        return repository.informarClientePorCodigo(codigo).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
    }
}
