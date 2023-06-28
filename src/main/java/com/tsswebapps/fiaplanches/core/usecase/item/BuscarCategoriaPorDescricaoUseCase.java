package com.tsswebapps.fiaplanches.core.usecase.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarCategoriaPorDescricaoPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.dto.TipoExcecao;
import com.tsswebapps.fiaplanches.core.exception.ApplicationException;

public class BuscarCategoriaPorDescricaoUseCase implements BuscarCategoriaPorDescricaoPort {
    private final CategoriaRepository repository;

    public BuscarCategoriaPorDescricaoUseCase(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria executar(String descricao) {
        if(descricao == null || descricao.isEmpty()) {
            throw new ApplicationException(TipoExcecao.CODIGO_NAO_INFORMADO);
        }
        return repository.buscarcategoriaPorDescricao(descricao).orElseThrow(
                () -> new ApplicationException(TipoExcecao.RECURSO_NAO_ENCONTRADO));
    }
}
