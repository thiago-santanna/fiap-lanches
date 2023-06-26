package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarCategoriaPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;

public class SalvarCategoriaUseCase implements SalvarCategoriaPort {

    private final CategoriaRepository repository;

    public SalvarCategoriaUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria executar(Categoria categoria) {
        return repository.salvar(categoria);
    }
}
