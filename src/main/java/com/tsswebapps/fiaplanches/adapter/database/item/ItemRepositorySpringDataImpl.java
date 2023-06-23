package com.tsswebapps.fiaplanches.adapter.database.item;

import com.tsswebapps.fiaplanches.adapter.mapper.ItemMapper;
import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;

import java.util.List;

public class ItemRepositorySpringDataImpl implements ItemRepository {

    private final ItemMapper mapper;

    public ItemRepositorySpringDataImpl(ItemMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ItemCadastrado salvar(Item item) {
        return null;
    }

    @Override
    public List<ItemCadastrado> listarItensPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public void apagar(Long codigo) {

    }
}
