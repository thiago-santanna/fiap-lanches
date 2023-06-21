package com.tsswebapps.fiaplanches.core.domain.pedido;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Pedido {
    private final String comanda;
    private final BigDecimal valorTotal;
    private final LocalDateTime dataHoraPedido;
    private final SituacaoPedido situacaoPedido;
    private final Cliente cliente;
    private Set<Item> itensPedido = new HashSet<>();

    public Pedido(BigDecimal valorTotal, LocalDateTime dataHoraPedido, SituacaoPedido situacaoPedido, Cliente cliente, Set<Item> itensPedido) {
        this.comanda = this.gerarComanda(4);
        this.valorTotal = valorTotal;
        this.dataHoraPedido = dataHoraPedido;
        this.situacaoPedido = situacaoPedido;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }

    public Set<Item> getItems() {
        return Collections.unmodifiableSet(this.itensPedido);
    }

    public String getComanda() {
        return comanda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public SituacaoPedido getSituacaoPedido() {
        return situacaoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private String gerarComanda(int digitos) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < digitos; i++) {
            int digit = random.nextInt(10);
            code.append(digit);
        }
        return code.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(comanda, pedido.comanda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comanda);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "comanda='" + comanda + '\'' +
                ", valorTotal=" + valorTotal +
                ", dataHoraPedido=" + dataHoraPedido +
                ", situacaoPedido=" + situacaoPedido +
                ", cliente=" + cliente +
                ", itensPedido=" + itensPedido +
                '}';
    }
}
