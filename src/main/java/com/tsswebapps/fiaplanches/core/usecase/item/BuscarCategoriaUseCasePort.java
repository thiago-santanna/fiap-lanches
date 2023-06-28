package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarCategoriaPorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class BuscarCategoriaUseCasePort implements BuscarCategoriaPorCodigoPort {

    private final CategoriaRepository repository;

    public BuscarCategoriaUseCasePort(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria executar(Long codigo) {
        if(codigo == null || codigo.toString().isEmpty()) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }
        return repository.buscarItemPorCodigo(codigo).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
    }
}
