package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

import java.util.List;

public interface BuscarTodosItensPort {
    List<ItemCadastrado> executar();
}
