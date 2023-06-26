package com.tsswebapps.fiaplanches.core.domain.Item.ports.out;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    ItemCadastrado salvar(Item item);
    List<ItemCadastrado> listarItensPorCategoria(Categoria categoria);
    Optional<ItemCadastrado> buscarItemPorCodigo(Long id);
    void apagar(Long codigo);
}
