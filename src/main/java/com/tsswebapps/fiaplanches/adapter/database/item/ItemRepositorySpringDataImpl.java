package com.tsswebapps.fiaplanches.adapter.database.item;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.ItemSpringDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.mapper.ItemMapper;
import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class ItemRepositorySpringDataImpl implements ItemRepository {

    private final ItemSpringDataJpaRepository repository;

    private final ItemMapper mapper;

    public ItemRepositorySpringDataImpl(ItemSpringDataJpaRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ItemCadastrado salvar(Item item) {
        ItemEntity itemEntity = repository.save(mapper.toItemEntity(item));
        return mapper.toItemCadastrado(itemEntity);
    }

    @Override
    public List<ItemCadastrado> listarItensPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public Optional<ItemCadastrado> buscarItemPorCodigo(Long id) {
        Optional<ItemEntity> itemEntity = repository.findById(id);
        return itemEntity.map(mapper::toItemCadastrado).or(Optional::empty);
    }

    @Override
    public void apagar(Long codigo) {
        repository.deleteById(codigo);
    }
}
