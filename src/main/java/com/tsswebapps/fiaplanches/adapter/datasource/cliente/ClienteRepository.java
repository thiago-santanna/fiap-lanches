package com.tsswebapps.fiaplanches.adapter.datasource.cliente;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteEntity> InformarClientePorCpf(String cpf);
    ClienteCadastrado CadastrarClienteDadosBasico(ClienteEntity cliente);
}
