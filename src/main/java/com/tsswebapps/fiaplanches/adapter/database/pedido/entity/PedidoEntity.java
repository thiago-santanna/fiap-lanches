package com.tsswebapps.fiaplanches.adapter.database.pedido.entity;

import com.tsswebapps.fiaplanches.adapter.database.cliente.entity.ClienteEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.entity.ItemEntity;
import com.tsswebapps.fiaplanches.core.domain.pedido.SituacaoPedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comanda;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraPedido;
    private SituacaoPedido situacaoPedido;
    @ManyToOne(targetEntity = ClienteEntity.class)
    private ClienteEntity cliente;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ItemPedidoEntity> itensPedido = new HashSet<>();
}
