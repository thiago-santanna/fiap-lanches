package com.tsswebapps.fiaplanches.core.domain.cliente.ports.out;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteCadastrado> informarClientePorCpf(String cpf);
    ClienteCadastrado cadastrar(Cliente cliente);
    //ClienteCadastrado alterar(Cliente cliente);
}
