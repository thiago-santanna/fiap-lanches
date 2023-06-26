package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarItemPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;

public class SalvarItemUseCase implements SalvarItemPort {

    private final ItemRepository repository;

    public SalvarItemUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemCadastrado executar(Item item) {
        // Verificar se existe categoria informada
        // fazer um get no recurso de categoria
        // se já esistir eu vou informar essa instancia.
        // caso não, vou deixar seguir e a api vai criar uma nova





        return repository.salvar(item);
    }
}
