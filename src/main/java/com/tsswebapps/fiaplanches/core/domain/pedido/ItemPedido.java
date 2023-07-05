package com.tsswebapps.fiaplanches.core.domain.pedido;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

public class ItemPedido {
    Long id;
    @Valid
    private Item item;
    @Positive
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", item=" + item +
                ", quantidade=" + quantidade +
                '}';
    }
}
