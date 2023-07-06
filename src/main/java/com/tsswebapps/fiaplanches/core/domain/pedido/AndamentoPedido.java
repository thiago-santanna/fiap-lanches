package com.tsswebapps.fiaplanches.core.domain.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AndamentoPedido {
    private String comanda;
    private LocalDateTime dataHoraPedido;
    private SituacaoPedido situacaoPedido;
    private String tempoQueFoipedido;

    public AndamentoPedido(String comanda, LocalDateTime dataHoraPedido, SituacaoPedido situacaoPedido) {
        this.comanda = comanda;
        this.dataHoraPedido = dataHoraPedido;
        this.situacaoPedido = situacaoPedido;
    }

    public String getComanda() {
        return comanda;
    }

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public SituacaoPedido getSituacaoPedido() {
        return situacaoPedido;
    }

    public String getTempoQueFoipedido() {
        return tempoQueFoipedido;
    }

    public void setTempoQueFoipedido(String tempoQueFoipedido) {
        this.tempoQueFoipedido = tempoQueFoipedido;
    }
}
