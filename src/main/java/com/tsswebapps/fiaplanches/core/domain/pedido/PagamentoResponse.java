package com.tsswebapps.fiaplanches.core.domain.pedido;

public class PagamentoResponse {
    private String number4sset;
    private String numberDoc;
    private String statusPagamento;
    private String situacaoPedido;

    private String observacao;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNumber4sset() {
        return number4sset;
    }

    public void setNumber4sset(String number4sset) {
        this.number4sset = number4sset;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(String situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }
}
