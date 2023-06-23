package com.tsswebapps.fiaplanches.adapter.mapper;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {
    ItemEntity toItemEntity(Item item);

    ItemCadastrado toItemCadastrado(ItemEntity itemEntity);
}
