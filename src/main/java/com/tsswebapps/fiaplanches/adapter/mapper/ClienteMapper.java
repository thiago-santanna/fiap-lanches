package com.tsswebapps.fiaplanches.adapter.mapper;

import com.tsswebapps.fiaplanches.adapter.datasource.cliente.database.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ClienteMapper {
    ClienteCadastrado toClienteCadastrado(Cliente cliente);
    ClienteCadastrado toClienteCadastrado(ClienteEntity clienteEntity);
    ClienteEntity toClienteEntity(Cliente cliente);
}
