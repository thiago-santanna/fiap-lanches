package com.tsswebapps.fiaplanches.core.domain.cliente.ports.in;

import java.util.UUID;

public interface ApagarClientePort {
    void executar(Long codigo);
}
