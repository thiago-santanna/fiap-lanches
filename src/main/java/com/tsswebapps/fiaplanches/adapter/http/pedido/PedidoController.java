package com.tsswebapps.fiaplanches.adapter.http.pedido;

import com.tsswebapps.fiaplanches.core.domain.pedido.ports.PedidoCriadoResponse;
import com.tsswebapps.fiaplanches.core.domain.pedido.ports.in.CriarPedidoPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoPort criarPedidoPort;

    public PedidoController(CriarPedidoPort criarPedidoPort) {
        this.criarPedidoPort = criarPedidoPort;
    }

    @PostMapping(value = "/{cpf}", produces = "application/json")
    public ResponseEntity<PedidoCriadoResponse> criarPedido(@PathVariable String cpf) {
        return new ResponseEntity<>(criarPedidoPort.executar(cpf), HttpStatus.CREATED);
    }
}
