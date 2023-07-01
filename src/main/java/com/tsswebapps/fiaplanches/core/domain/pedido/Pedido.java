package com.tsswebapps.fiaplanches.core.domain.pedido;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Pedido {
    private String comanda;
    private BigDecimal valorTotal;
    private LocalDateTime dataHoraPedido;
    private SituacaoPedido situacaoPedido;
    private Cliente cliente;
    private Set<ItemPedido> itensPedido = new HashSet<>();
}
