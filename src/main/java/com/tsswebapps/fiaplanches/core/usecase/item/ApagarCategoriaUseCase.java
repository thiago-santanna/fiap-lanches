package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.ApagarCategoriaPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;

public class ApagarCategoriaUseCase implements ApagarCategoriaPort {

    private final CategoriaRepository repository;

    public ApagarCategoriaUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void apagar(Long codigo) {
        repository.apagar(codigo);
    }
}
