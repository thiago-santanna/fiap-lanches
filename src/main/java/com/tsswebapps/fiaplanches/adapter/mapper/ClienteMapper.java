package com.tsswebapps.fiaplanches.adapter.mapper;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteMapper {
    Cliente toCliente(ClienteRequest clienteRequest);
    ClienteCadastrado toClienteCadastrado(ClienteRequest clienteRequest);
    ClienteCadastrado toClienteCadastrado(Cliente cliente);
    ClienteEntity toClienteEntity(Cliente cliente);
    ClienteCadastrado toClienteCadastrado(ClienteEntity clienteEntity);
}
