package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteLogin;

public interface AcessarNomeEmailPort {
    ClienteCadastrado executar(ClienteLogin cliente);
}
