package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.CategoriaCadastrada;

public interface SalvarCategoriaPort {

    CategoriaCadastrada executar(Categoria categoria);
}
