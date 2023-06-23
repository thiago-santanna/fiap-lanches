package com.tsswebapps.fiaplanches.adapter.http.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarItemPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final SalvarItemPort salvarItemPort;

    public ItemController(SalvarItemPort salvarItemPort) {
        this.salvarItemPort = salvarItemPort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemCadastrado> salvar(@RequestBody @Valid Item item) {
        return new ResponseEntity<>(salvarItemPort.executar(item), HttpStatus.CREATED);
    }
}
