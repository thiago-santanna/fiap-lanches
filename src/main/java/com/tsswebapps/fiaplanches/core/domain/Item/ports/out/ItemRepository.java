package com.tsswebapps.fiaplanches.core.domain.Item.ports.out;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

import java.util.List;

public interface ItemRepository {
    ItemCadastrado salvar(Item item);
    List<ItemCadastrado> listarItensPorCategoria(Categoria categoria);
    void apagar(Long codigo);
}
