package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.ApagarClientePort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.BuscarClientePorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarClientePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastrarClientePort cadastrarPort;
    private final AcessarPorCpfPort acessarPorCpfPort;
    private final BuscarClientePorCodigoPort buscarClientePorCodigoPort;
    private final ApagarClientePort apagarClientePort;

    public ClienteController(CadastrarClientePort cadastroSimplificado,
                             AcessarPorCpfPort acessarPorCpfPort,
                             BuscarClientePorCodigoPort buscarClientePorCodigoPort,
                             ApagarClientePort apagarClientePort) {
        this.cadastrarPort = cadastroSimplificado;
        this.acessarPorCpfPort = acessarPorCpfPort;
        this.buscarClientePorCodigoPort = buscarClientePorCodigoPort;
        this.apagarClientePort = apagarClientePort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastroEmailNome(
            @RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(cadastrarPort.executar(cliente), HttpStatus.CREATED);
    }

    @GetMapping(value = "/cpf/{cpf}", produces = "application/json")
    @Transactional
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }

    @GetMapping( value = "/{codigo}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> identificarPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(buscarClientePorCodigoPort.executar(codigo), HttpStatus.OK);
    }

    @DeleteMapping( value = "/{codigo}")
    @Transactional
    public ResponseEntity<Void> apagarClientePorCodigo(@PathVariable Long codigo) {
        apagarClientePort.executar(codigo);
        return ResponseEntity.noContent().build();
    }
}
