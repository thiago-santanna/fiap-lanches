package com.tsswebapps.fiaplanches.adapter.mapper;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoriaMapper {
    CategoriaEntity toCategoriaEntity(Categoria categoria);
    Categoria toCategoria(CategoriaEntity categoria);
}
