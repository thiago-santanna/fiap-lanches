package com.tsswebapps.fiaplanches.adapter.database.pedido.entity;

import com.tsswebapps.fiaplanches.adapter.database.cliente.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;

import javax.persistence.*;

@Entity
@Table(name = "itens_pedidos")
public class ItemPedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ItemEntity.class)
    private ItemEntity item;
    private int quantidade;
}
