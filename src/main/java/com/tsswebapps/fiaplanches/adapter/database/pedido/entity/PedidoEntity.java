package com.tsswebapps.fiaplanches.adapter.database.pedido.entity;

import com.tsswebapps.fiaplanches.adapter.database.cliente.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.core.domain.pedido.SituacaoPedido;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedidos")
@ToString
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String comanda;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraPedido;
    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacaoPedido;
    @ManyToOne(targetEntity = ClienteEntity.class)
    private ClienteEntity cliente;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemPedidoEntity> itensPedido = new HashSet<>();

    public PedidoEntity() {
        this.situacaoPedido = SituacaoPedido.PENDENTE;
    }

    public void adicionarItemPedidoEntity(ItemPedidoEntity itemPedidoEntity) {
        this.itensPedido.add(itemPedidoEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComanda() {
        return comanda;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public SituacaoPedido getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(SituacaoPedido situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedidoEntity> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Set<ItemPedidoEntity> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoEntity that = (PedidoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(comanda, that.comanda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comanda);
    }
}
