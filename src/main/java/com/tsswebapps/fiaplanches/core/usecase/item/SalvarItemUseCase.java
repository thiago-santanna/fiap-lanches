package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarItemPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class SalvarItemUseCase implements SalvarItemPort {
    private final ItemRepository itemRepository;
    private final CategoriaRepository categoriaRepository;

    public SalvarItemUseCase(ItemRepository itemRepository, CategoriaRepository categoriaRepository) {
        this.itemRepository = itemRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ItemCadastrado executar(Item item) {
        var validar = new ValidarCategoria(categoriaRepository);
        validar.validarCategoria(item);

        return itemRepository.salvar(item);
    }


}
