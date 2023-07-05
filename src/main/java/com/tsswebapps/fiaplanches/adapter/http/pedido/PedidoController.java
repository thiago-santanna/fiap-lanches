package com.tsswebapps.fiaplanches.adapter.http.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoRequest;
import com.tsswebapps.fiaplanches.core.domain.pedido.ItemPedidoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.PedidoCriadoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.AdicionarItemAoPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.CriarPedidoPort;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.RemoveItemDoPedidoPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoPort criarPedidoPort;
    public final AdicionarItemAoPedidoPort adicionarItemAoPedidoPort;

    public final RemoveItemDoPedidoPort removeItemDoPedidoPort;

    public PedidoController(CriarPedidoPort criarPedidoPort, AdicionarItemAoPedidoPort adicionarItemAoPedidoPort, RemoveItemDoPedidoPort removeItemDoPedidoPort) {
        this.criarPedidoPort = criarPedidoPort;
        this.adicionarItemAoPedidoPort = adicionarItemAoPedidoPort;
        this.removeItemDoPedidoPort = removeItemDoPedidoPort;
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

    @PostMapping("/{comanda}")
    public ResponseEntity<?> confirmarPedido() {


        return ResponseEntity.ok().build();
    }
}
