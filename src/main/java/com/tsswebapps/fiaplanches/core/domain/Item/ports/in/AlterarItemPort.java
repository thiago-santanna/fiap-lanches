package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemAlterar;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;

public interface AlterarItemPort {
    ItemCadastrado executar(ItemAlterar item, Long id);
}
