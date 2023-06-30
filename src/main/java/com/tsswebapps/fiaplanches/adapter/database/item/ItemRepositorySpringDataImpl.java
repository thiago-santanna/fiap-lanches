package com.tsswebapps.fiaplanches.adapter.database.item;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.CategoriaSpringDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.ItemSpringDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.mapper.ItemMapper;
import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemAlterar;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ItemRepositorySpringDataImpl implements ItemRepository {

    private final ItemSpringDataJpaRepository itemSpringDataJpaRepository;
    private final CategoriaSpringDataJpaRepository categoriaRepository;
    private final ItemMapper mapper;


    public ItemRepositorySpringDataImpl(ItemSpringDataJpaRepository itemSpringDataJpaRepository, CategoriaSpringDataJpaRepository categoriaRepository, ItemMapper mapper) {
        this.itemSpringDataJpaRepository = itemSpringDataJpaRepository;
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ItemCadastrado salvar(Item item) {
        ItemEntity mapperItemEntity = mapper.toItemEntity(item);
        mapperItemEntity.setCategoria(categoriaRepository.findByDescricao(item.getCategoria().descricao()).get());
        return mapper.toItemCadastrado(itemSpringDataJpaRepository.save(mapperItemEntity));
    }

    @Override
    public ItemCadastrado alterar(ItemAlterar item, Long id) {
        ItemEntity itemEntity = itemSpringDataJpaRepository.findById(id).orElseThrow(
                () -> new ApplicationException());
        updateEntity(item, itemEntity);
        return mapper.toItemCadastrado(itemSpringDataJpaRepository.save(itemEntity));
    }

    @Override
    public ItemCadastrado alteraCategoriaItem(Long idItem, Categoria categoria) {
        ItemEntity mapperItemEntity = itemSpringDataJpaRepository.findById(idItem)
                .orElseThrow(() -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));

        mapperItemEntity.setCategoria(categoriaRepository.findByDescricao(categoria.descricao()).get());
        return mapper.toItemCadastrado(itemSpringDataJpaRepository.save(mapperItemEntity));
    }

    private static void updateEntity(ItemAlterar item, ItemEntity itemEntity) {
        itemEntity.setReferenciaFabricante(item.referenciaFabricante());
        itemEntity.setNome(item.nome());
        itemEntity.setDescricao(item.descricao());
        itemEntity.setValor(item.valor());
    }

    @Override
    public List<ItemCadastrado> buscarTodosItens() {
        return itemSpringDataJpaRepository.findAll().stream()
                .map(itemEntity -> mapper.toItemCadastrado(itemEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemCadastrado> listarItensPorCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public Optional<ItemCadastrado> buscarItemPorCodigo(Long id) {
        Optional<ItemEntity> itemEntity = itemSpringDataJpaRepository.findById(id);
        return itemEntity.map(mapper::toItemCadastrado).or(Optional::empty);
    }

    @Override
    @Transactional
    public void apagar(Long codigo) {
        itemSpringDataJpaRepository.deleteById(codigo);
    }
}
