package com.tsswebapps.fiaplanches.adapter.http.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Item;
import com.tsswebapps.fiaplanches.core.domain.Item.ItemCadastrado;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarItemPorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarItemPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final SalvarItemPort salvarItemPort;
    private final BuscarItemPorCodigoPort buscarItemPorCodigoPort;

    public ItemController(SalvarItemPort salvarItemPort, BuscarItemPorCodigoPort itemPorCodigoPort) {
        this.salvarItemPort = salvarItemPort;
        this.buscarItemPorCodigoPort = itemPorCodigoPort;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemCadastrado> buscarPorItem(@PathVariable Long codigo) {
        return new ResponseEntity<>(buscarItemPorCodigoPort.executar(codigo), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemCadastrado> salvar(@RequestBody @Valid Item item) {
        return new ResponseEntity<>(salvarItemPort.executar(item), HttpStatus.CREATED);
    }
}
