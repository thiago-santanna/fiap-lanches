package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.AlterarItemCategoriaPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;

public class AlterarItemCategoriaUseCase implements AlterarItemCategoriaPort {
    private final ItemRepository repository;
    private final CategoriaRepository categoriaRepository;

    public AlterarItemCategoriaUseCase(ItemRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ItemCadastrado executar(Long idItem, Categoria categoria) {
        var validar = new ValidarCategoria(categoriaRepository);
        validar.validarCategoria(categoria);

        return repository.alteraCategoriaItem(idItem, categoria);
    }
}
