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
    @ManyToOne()
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private ItemEntity item;
    private int quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
