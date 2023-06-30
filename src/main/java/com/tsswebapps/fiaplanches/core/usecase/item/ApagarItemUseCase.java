package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.ApagarItemPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;

public class ApagarItemUseCase implements ApagarItemPort {

    private final ItemRepository repository;

    public ApagarItemUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(Long codigo) {
        repository.apagar(codigo);
    }
}
