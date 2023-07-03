package com.tsswebapps.fiaplanches.adapter.mapper;

import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.ItemPedidoEntity;
import com.tsswebapps.fiaplanches.adapter.database.pedido.entity.PedidoEntity;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.Pedido;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoEntity toPedidoEntity(Pedido pedido);
    ItemPedidoEntity toItemPedidoEntity(ItemPedido itemPedido);
}
