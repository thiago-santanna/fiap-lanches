package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteLogin;
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
    private final AcessarNomeEmailPort acessarNomeEmailPort;

    public ClienteController(CadastrarClientePort cadastroSimplificado,
                             AlterarClientePort alterarClientePort, AcessarPorCpfPort acessarPorCpfPort,
                             BuscarClientePorCodigoPort buscarClientePorCodigoPort,
                             ApagarClientePort apagarClientePort, AcessarNomeEmailPort acessarNomeEmailPort) {
        this.cadastrarPort = cadastroSimplificado;
        this.alterarClientePort = alterarClientePort;
        this.acessarPorCpfPort = acessarPorCpfPort;
        this.buscarClientePorCodigoPort = buscarClientePorCodigoPort;
        this.apagarClientePort = apagarClientePort;
        this.acessarNomeEmailPort = acessarNomeEmailPort;
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
    public ResponseEntity<ClienteCadastrado> logarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }

    @GetMapping( value = "/{id}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> logarPorCodigo(@PathVariable Long id) {
        return new ResponseEntity<>(buscarClientePorCodigoPort.executar(id), HttpStatus.OK);
    }

    @GetMapping( value = "/login", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> logarPorCodigo(@RequestBody ClienteLogin cliente) {
        return new ResponseEntity<>(acessarNomeEmailPort.executar(cliente), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarClientePorCodigo(@PathVariable Long id) {
        apagarClientePort.executar(id);
        return ResponseEntity.noContent().build();
    }
}
