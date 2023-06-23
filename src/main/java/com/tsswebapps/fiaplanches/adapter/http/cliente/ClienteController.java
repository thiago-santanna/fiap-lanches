package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastrarClientePort cadastrarPort;

    private final AlterarClientePort alterarClientePort;
    private final AcessarPorCpfPort acessarPorCpfPort;
    private final BuscarClientePorCodigoPort buscarClientePorCodigoPort;
    private final ApagarClientePort apagarClientePort;

    public ClienteController(CadastrarClientePort cadastroSimplificado,
                             AlterarClientePort alterarClientePort, AcessarPorCpfPort acessarPorCpfPort,
                             BuscarClientePorCodigoPort buscarClientePorCodigoPort,
                             ApagarClientePort apagarClientePort) {
        this.cadastrarPort = cadastroSimplificado;
        this.alterarClientePort = alterarClientePort;
        this.acessarPorCpfPort = acessarPorCpfPort;
        this.buscarClientePorCodigoPort = buscarClientePorCodigoPort;
        this.apagarClientePort = apagarClientePort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastrarCliente(
            @RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(cadastrarPort.executar(cliente), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> alterarCliente(
            @RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(alterarClientePort.executar(cliente), HttpStatus.OK);
    }

    @GetMapping(value = "/cpf/{cpf}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }

    @GetMapping( value = "/{codigo}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> identificarPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(buscarClientePorCodigoPort.executar(codigo), HttpStatus.OK);
    }

    @DeleteMapping( value = "/{codigo}")
    public ResponseEntity<Void> apagarClientePorCodigo(@PathVariable Long codigo) {
        apagarClientePort.executar(codigo);
        return ResponseEntity.noContent().build();
    }
}
