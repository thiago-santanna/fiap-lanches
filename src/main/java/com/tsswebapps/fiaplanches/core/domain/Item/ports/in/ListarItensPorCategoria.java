package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

import java.util.List;

public interface ListarItensPorCategoria {
    List<ItemCadastrado> executar(Categoria categoria);
}
