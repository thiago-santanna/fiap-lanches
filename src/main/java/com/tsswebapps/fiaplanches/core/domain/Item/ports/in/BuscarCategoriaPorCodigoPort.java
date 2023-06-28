package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;

public interface BuscarCategoriaPorCodigoPort {
    Categoria executar(Long codigo);
}
