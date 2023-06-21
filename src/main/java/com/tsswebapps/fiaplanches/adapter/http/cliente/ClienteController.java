package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.AcessarPorCpfPort;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastroSimplificadoPort;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastroSimplificadoPort cadastroSimplificado;
    private final AcessarPorCpfPort acessarPorCpfPort;

    public ClienteController(CadastroSimplificadoPort cadastroSimplificado,
                             AcessarPorCpfPort acessarPorCpfPort) {
        this.cadastroSimplificado = cadastroSimplificado;
        this.acessarPorCpfPort = acessarPorCpfPort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastroEmailNome(
            @RequestBody @Valid ClienteRequest cliente) {
        return new ResponseEntity<>(cadastroSimplificado.executar(cliente), HttpStatus.CREATED);
    }

    @PostMapping("/{cpf}")
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpf) {
        return new ResponseEntity<>(acessarPorCpfPort.executar(cpf), HttpStatus.OK);
    }
}
