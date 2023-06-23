package com.tsswebapps.fiaplanches.application.springconfig;

import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.ApagarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.BuscarClientePorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.usecase.cliente.AcessarPorCpfUseCase;
import com.tsswebapps.fiaplanches.core.usecase.cliente.ApagarClienteUseCase;
import com.tsswebapps.fiaplanches.core.usecase.cliente.BuscarClientePorCodigoUseCase;
import com.tsswebapps.fiaplanches.core.usecase.cliente.CadastrarClienteUseCase;
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
}
