package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarTodasCategoriasPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;

import java.util.List;

public class BuscarTodasCategoriasPortUseCase implements BuscarTodasCategoriasPort {
    private final CategoriaRepository repository;

    public BuscarTodasCategoriasPortUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> executar() {
        return repository.listarTodas();
    }
}
