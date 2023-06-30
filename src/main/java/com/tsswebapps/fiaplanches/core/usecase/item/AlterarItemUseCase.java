package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemAlterar;
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
    public ItemCadastrado executar(ItemAlterar item, Long id) {
        return repository.alterar(item, id);
    }
}
