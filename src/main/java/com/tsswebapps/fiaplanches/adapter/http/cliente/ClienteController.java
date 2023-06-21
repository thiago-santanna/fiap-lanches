package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.Cliente;
import com.tsswebapps.fiaplanches.core.domain.cliente.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastrarPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastrarPort cadastrarPort;
    private final AcessarPorCpfPort acessarPorCpfPort;

    public ClienteController(CadastrarPort cadastroSimplificado,
                             AcessarPorCpfPort acessarPorCpfPort) {
        this.cadastrarPort = cadastroSimplificado;
        this.acessarPorCpfPort = acessarPorCpfPort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastroEmailNome(
            @RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<>(cadastrarPort.executar(cliente), HttpStatus.CREATED);
    }

    @PostMapping("/{cpf}")
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }
}
