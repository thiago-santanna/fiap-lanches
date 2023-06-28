package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarTodasCategoriasPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;

import java.util.List;

public class BuscarTodasCategoriasUseCase implements BuscarTodasCategoriasPort {
    private final CategoriaRepository repository;

    public BuscarTodasCategoriasUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> executar() {
        return repository.listarTodas();
    }
}
