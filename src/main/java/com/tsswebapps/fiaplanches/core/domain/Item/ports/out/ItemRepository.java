package com.tsswebapps.fiaplanches.core.domain.Item.ports.out;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemAlterar;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    ItemCadastrado salvar(Item item);
    ItemCadastrado alterar(ItemAlterar item, Long id);
    ItemCadastrado alteraCategoriaItem(Long idItem, Categoria categoria);
    List<ItemCadastrado> buscarTodosItens();
    List<ItemCadastrado> listarItensPorCategoria(Categoria categoria);
    Optional<ItemCadastrado> buscarItemPorCodigo(Long id);
    void apagar(Long codigo);
}
