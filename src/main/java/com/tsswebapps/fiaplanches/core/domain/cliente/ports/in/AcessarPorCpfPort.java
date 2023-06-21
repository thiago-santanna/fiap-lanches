package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;

public interface AcessarPorCpfPort {
    ClienteCadastrado executar(String cpf);
}
