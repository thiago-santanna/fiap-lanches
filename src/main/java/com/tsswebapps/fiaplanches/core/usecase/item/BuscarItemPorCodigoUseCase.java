package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarItemPorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class BuscarItemPorCodigoUseCase implements BuscarItemPorCodigoPort {

    private final ItemRepository repository;

    public BuscarItemPorCodigoUseCase(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemCadastrado executar(Long codigo) {
        if(codigo == null || codigo == 0 || codigo < 0) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }
        return repository.buscarItemPorCodigo(codigo).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
    }
}
