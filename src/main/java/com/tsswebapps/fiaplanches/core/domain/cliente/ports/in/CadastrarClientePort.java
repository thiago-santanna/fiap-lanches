package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

public interface CadastrarClientePort {
    ClienteCadastrado executar(Cliente cliente);
}
