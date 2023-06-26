package com.tsswebapps.fiaplanches.core.domain.Item.ports.out;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Categoria salvar(Categoria categoria);
    List<Categoria> listarTodas();
    Optional<Categoria> buscarItemPorCodigo(Long id);
    void apagar(Long codigo);
}
