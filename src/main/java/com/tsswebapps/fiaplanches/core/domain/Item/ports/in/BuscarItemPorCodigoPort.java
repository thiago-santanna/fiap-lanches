package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

public interface BuscarItemPorCodigoPort {
    ItemCadastrado executar(Long id);
}
