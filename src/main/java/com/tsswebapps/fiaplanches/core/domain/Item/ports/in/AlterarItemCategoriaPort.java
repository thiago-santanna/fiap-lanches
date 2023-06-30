package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

public interface AlterarItemCategoriaPort {
    ItemCadastrado executar(Long idItem, Categoria categoria);
}
