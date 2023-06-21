package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;

public interface CadastroSimplificadoPort {
    ClienteCadastrado executar(ClienteRequest cliente);
}
