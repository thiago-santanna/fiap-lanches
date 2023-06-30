package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

class ValidarCategoria {

    private final CategoriaRepository categoriaRepository;

    ValidarCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    void validarCategoria(Item item) {
        if( item.getCategoria() == null) {
            throw  new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO);
        }
        else {
            categoriaRepository.buscarcategoriaPorDescricao(item.getCategoria().descricao())
                    .orElseThrow(() -> new ApplicationException(TipoExcecao.CATEGORIA_NAO_ENCONTRADA));
        }
    }

    void validarCategoria(Categoria categoria) {
        if( categoria == null) {
            throw  new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO);
        }
        else {
            categoriaRepository.buscarcategoriaPorDescricao(categoria.descricao())
                    .orElseThrow(() -> new ApplicationException(TipoExcecao.CATEGORIA_NAO_ENCONTRADA));
        }
    }
}
