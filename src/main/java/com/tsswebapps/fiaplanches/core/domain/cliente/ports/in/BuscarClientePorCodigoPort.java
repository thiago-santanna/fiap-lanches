package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

import java.util.UUID;

public interface BuscarClientePorCodigoPort {
    ClienteCadastrado executar(UUID codigo);
}
