package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.AlterarItemPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class AlterarItemUseCase implements AlterarItemPort {

    private final ItemRepository repository;

    public AlterarItemUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemCadastrado executar(Item item) {
        if(item.getId() == null || item.getId().toString().isEmpty()) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }

        // Verificar se existe categoria informada
        // fazer um get no recurso de categoria
        // se já esistir eu vou informar essa instancia.
        // caso não, vou deixar seguir e a api vai criar uma nova

        return repository.salvar(item);
    }
}
