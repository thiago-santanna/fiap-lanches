package com.tsswebapps.fiaplanches.core.domain.Item.ports.out;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.CategoriaCadastrada;

public interface CategoriaRepository {
    CategoriaCadastrada salvar(Categoria categoria);
    void apagar(Long id);
}
