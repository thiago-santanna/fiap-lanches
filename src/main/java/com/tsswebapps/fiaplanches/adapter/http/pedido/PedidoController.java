package com.tsswebapps.fiaplanches.adapter.http.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.*;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoPort criarPedidoPort;
    public final AdicionarItemAoPedidoPort adicionarItemAoPedidoPort;

    public final RemoveItemDoPedidoPort removeItemDoPedidoPort;

    public final ConfirmarPedidoPort confirmarPedidoPort;

    public final PagarPedidoPort pagarPedidoPort;
    public final FinalizarPedidoPort finalizarPedidoPort;
    public final EntregarPedidoPort entregarPedidoPort;
    public final ChecarAndamentoPedidoPort checarAndamentoPedidoPort;

    public PedidoController(CriarPedidoPort criarPedidoPort, AdicionarItemAoPedidoPort adicionarItemAoPedidoPort, RemoveItemDoPedidoPort removeItemDoPedidoPort, ConfirmarPedidoPort confirmarPedidoPort, PagarPedidoPort pagarPedidoPort, FinalizarPedidoPort finalizarPedidoPort, EntregarPedidoPort entregarPedidoPort, ChecarAndamentoPedidoPort checarAndamentoPedidoPort) {
        this.criarPedidoPort = criarPedidoPort;
        this.adicionarItemAoPedidoPort = adicionarItemAoPedidoPort;
        this.removeItemDoPedidoPort = removeItemDoPedidoPort;
        this.confirmarPedidoPort = confirmarPedidoPort;
        this.pagarPedidoPort = pagarPedidoPort;
        this.finalizarPedidoPort = finalizarPedidoPort;
        this.entregarPedidoPort = entregarPedidoPort;
        this.checarAndamentoPedidoPort = checarAndamentoPedidoPort;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<PedidoCriadoResponse> criarPedido(
            @RequestParam(value = "cpf", required = false) String cpf) {
        return new ResponseEntity<>(criarPedidoPort.executar(cpf), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{comanda}/item", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemPedidoResponse> adicionarItemPedido(@PathVariable String comanda, @RequestBody ItemPedidoRequest itemPedido) {

        return new ResponseEntity<>(adicionarItemAoPedidoPort.executar(comanda, itemPedido), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{comanda}/item/{referencia}", consumes = "application/json")
    public ResponseEntity<Void> removerItemPedido(@PathVariable String comanda, @PathVariable String referencia) {
        removeItemDoPedidoPort.executar(comanda, referencia);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{comanda}/confirmar")
    public ResponseEntity<Void> confirmarPedido(@PathVariable String comanda) {
        confirmarPedidoPort.executar(comanda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{comanda}/finalizar")
    public ResponseEntity<Void> finalizarPedido(@PathVariable String comanda) {
        finalizarPedidoPort.executar(comanda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{comanda}/entregar")
    public ResponseEntity<Void> entregarPedido(@PathVariable String comanda) {
        entregarPedidoPort.executar(comanda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{comanda}")
    public ResponseEntity<AndamentoPedido> chegarAndamentoPedido(@PathVariable String comanda) {
        return new ResponseEntity<>(checarAndamentoPedidoPort.executar(comanda),HttpStatus.OK);
    }

    @PostMapping("/{comanda}/pagar")
    public ResponseEntity<PagamentoResponse> pagarPedido(@PathVariable String comanda) {
        return new ResponseEntity(pagarPedidoPort.executar(comanda), HttpStatus.OK);
    }
}
