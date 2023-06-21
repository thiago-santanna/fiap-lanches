package com.tsswebapps.fiaplanches.ui.springconfig;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.ClienteRepository;
import com.tsswebapps.fiaplanches.core.usecase.cliente.AcessarPorCpfUseCase;
import com.tsswebapps.fiaplanches.core.usecase.cliente.CadastrarUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {
    @Bean
    public CadastrarPort cadastroSimplificadoPort(ClienteRepository repository) {
        return new CadastrarUseCase(repository);
    }
    @Bean
    public AcessarPorCpfPort acessarPorCpfPort(ClienteRepository repository) {
        return new AcessarPorCpfUseCase(repository);
    }
}
