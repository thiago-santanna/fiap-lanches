package com.tsswebapps.fiaplanches.core.usecase.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.ApagarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.BuscarClientePorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

import java.util.Optional;

public class ApagarClienteUseCase implements ApagarClientePort {

    private  final ClienteRepository repository;

    public ApagarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(Long codigo) {
        if(codigo == null || codigo == 0 || codigo < 0) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }

        var clienteCadastrado = repository.informarClientePorCodigo(codigo);
        if( clienteCadastrado.isEmpty()) {
            throw new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO);
        }
        
        repository.apagar(codigo);
    }
}
