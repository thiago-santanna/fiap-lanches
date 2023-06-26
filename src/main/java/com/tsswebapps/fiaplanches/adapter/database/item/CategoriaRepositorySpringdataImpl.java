package com.tsswebapps.fiaplanches.adapter.database.item;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.CategoriaSpringDataJpaRepository;
import com.tsswebapps.fiaplanches.adapter.mapper.CategoriaMapper;
import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoriaRepositorySpringdataImpl implements CategoriaRepository {

    private final CategoriaSpringDataJpaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaRepositorySpringdataImpl(CategoriaSpringDataJpaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        CategoriaEntity categoriaEntity = repository.save(mapper.toCategoriaEntity(categoria));
        return mapper.toCategoria(categoriaEntity);
    }

    @Override
    public List<Categoria> listarTodas() {
        return repository.findAll()
                .stream()
                .map(entity -> mapper.toCategoria(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Categoria> buscarItemPorCodigo(Long id) {
        Optional<CategoriaEntity> categoriaEntity = repository.findById(id);
        return categoriaEntity.map(mapper::toCategoria).or(Optional::empty);
    }

    @Override
    public void apagar(Long codigo) {
        repository.deleteById(codigo);
    }
}
