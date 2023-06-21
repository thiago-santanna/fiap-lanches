package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.BuscarClientePorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarClientePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastrarClientePort cadastrarPort;
    private final AcessarPorCpfPort acessarPorCpfPort;

    private final BuscarClientePorCodigoPort buscarClientePorCodigoPort;

    public ClienteController(CadastrarClientePort cadastroSimplificado,
                             AcessarPorCpfPort acessarPorCpfPort, BuscarClientePorCodigoPort buscarClientePorCodigoPort) {
        this.cadastrarPort = cadastroSimplificado;
        this.acessarPorCpfPort = acessarPorCpfPort;
        this.buscarClientePorCodigoPort = buscarClientePorCodigoPort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastroEmailNome(
            @RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(cadastrarPort.executar(cliente), HttpStatus.CREATED);
    }

    @PostMapping(value = "/cpf/{cpf}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }

    @GetMapping( value = "/{codigo}", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> identificarPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(buscarClientePorCodigoPort.executar(codigo), HttpStatus.OK);
    }
}
