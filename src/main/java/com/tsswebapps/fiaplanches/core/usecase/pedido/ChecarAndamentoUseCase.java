package com.tsswebapps.fiaplanches.core.usecase.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.AndamentoPedido;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.ChecarAndamentoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.out.PedidoRepository;

import java.time.Duration;
import java.time.LocalDateTime;

public class ChecarAndamentoUseCase implements ChecarAndamentoPedidoPort {

    private final PedidoRepository repository;

    public ChecarAndamentoUseCase(PedidoRepository repository) {
        this.repository = repository;
    }
    @Override
    public AndamentoPedido executar(String comanda) {
        var andamentoPedido = repository.checarAndamentoPedido(comanda);
        var dataAtual = LocalDateTime.now();
        Duration betweened = Duration.between(andamentoPedido.getDataHoraPedido(), dataAtual);
        long hours = betweened.toHours();
        long minutes = betweened.toMinutes() % 60;
        String diferencaFormatada = String.format("%02dh:%02dm", hours, minutes);
        andamentoPedido.setTempoQueFoipedido(diferencaFormatada);
        return andamentoPedido;
    }


}
