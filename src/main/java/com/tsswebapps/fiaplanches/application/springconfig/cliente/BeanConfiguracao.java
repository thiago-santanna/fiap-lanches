package com.tsswebapps.fiaplanches.application.springconfig.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.*;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.usecase.cliente.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {
    @Bean
    public CadastrarClientePort cadastroSimplificadoPort(ClienteRepository repository) {
        return new CadastrarClienteUseCase(repository);
    }
    @Bean
    public AcessarPorCpfPort acessarPorCpfPort(ClienteRepository repository) {
        return new AcessarPorCpfUseCase(repository);
    }
    @Bean
    public BuscarClientePorCodigoPort buscarClientePorCodigoPort(ClienteRepository repository) {
        return new BuscarClientePorCodigoUseCase(repository);
    }
    @Bean
    public ApagarClientePort apagarClientePort(ClienteRepository repository) {
        return new ApagarClienteUseCase(repository);
    }
    @Bean
    public AlterarClientePort alterarClientePort(ClienteRepository repository) {
        return new AlterarClienteUseCase(repository);
    }
}
