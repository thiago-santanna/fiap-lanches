package com.tsswebapps.fiaplanches.adapter.http.cliente;

import com.tsswebapps.fiaplanches.core.domain.cliente.dto.ClienteCadastrado;
import com.tsswebapps.fiaplanches.core.domain.cliente.ports.in.CadastroSimplificadoPort;
import com.tsswebapps.fiaplanches.core.usecase.cliente.dto.ClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastroSimplificadoPort cadastroSimplificado;

    public ClienteController(CadastroSimplificadoPort cadastroSimplificado) {
        this.cadastroSimplificado = cadastroSimplificado;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClienteCadastrado> cadastroEmailNome(
            @RequestBody @Valid ClienteRequest cliente) {
        return new ResponseEntity<>(cadastroSimplificado.executar(cliente), HttpStatus.CREATED);
    }

    @PostMapping("/{cpf}")
    public ResponseEntity<ClienteCadastrado> identificarPorCPF(@PathVariable String cpg) {

        return null;
    }
}
