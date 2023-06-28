package com.tsswebapps.fiaplanches.core.domain.Item.ports.in;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;

import java.util.List;

public interface BuscarTodasCategoriasPort {
    List<Categoria> executar();
}
