package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarTodosItensPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;

import java.util.List;

public class BuscarTodosItensUseCase implements BuscarTodosItensPort {
    private final ItemRepository repository;

    public BuscarTodosItensUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemCadastrado> executar() {
        return repository.buscarTodosItens();
    }
}
