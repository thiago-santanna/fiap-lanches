package com.tsswebapps.fiaplanches.ui.springconfig;

import com.tsswebapps.fiaplanches.adapter.mapper.ClienteMapper;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastroSimplificadoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.out.CadastrarClienteSimplesPort;
import com.tsswebapps.fiaplanches.core.usecase.cliente.CadastroSimplesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {
    @Bean
    public CadastroSimplificadoPort cadastroSimplificadoPort(CadastrarClienteSimplesPort port, ClienteMapper mapper) {
        return new CadastroSimplesUseCase(port, mapper);
    }
}
