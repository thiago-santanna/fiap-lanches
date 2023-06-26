package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;

public interface SalvarCategoriaPort {
    Categoria executar(Categoria categoria);
}
