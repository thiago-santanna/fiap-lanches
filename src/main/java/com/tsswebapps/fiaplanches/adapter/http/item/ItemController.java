package com.tsswebapps.fiaplanches.adapter.http.item;

import com.tsswebapps.fiaplanches.core.domain.Item.*;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final SalvarItemPort salvarItemPort;
    private final BuscarItemPorCodigoPort buscarItemPorCodigoPort;
    private final AlterarItemPort alterarItemPort;
    private final BuscarTodosItensPort buscarTodosItensPort;
    private final ApagarItemPort apagarItemPort;
    private final AlterarItemCategoriaPort alterarItemCategoriaPort;

    public ItemController(SalvarItemPort salvarItemPort, BuscarItemPorCodigoPort itemPorCodigoPort, AlterarItemPort alterarItemPort, BuscarTodosItensPort buscarTodosItensPort, ApagarItemPort apagarItemPort, AlterarItemCategoriaPort alterarItemCategoriaPort) {
        this.salvarItemPort = salvarItemPort;
        this.buscarItemPorCodigoPort = itemPorCodigoPort;
        this.alterarItemPort = alterarItemPort;
        this.buscarTodosItensPort = buscarTodosItensPort;
        this.apagarItemPort = apagarItemPort;
        this.alterarItemCategoriaPort = alterarItemCategoriaPort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCadastrado> buscarPorItem(@PathVariable Long id) {
        return new ResponseEntity<>(buscarItemPorCodigoPort.executar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemCadastrado>> buscarTodos() {
        return new ResponseEntity<>(buscarTodosItensPort.executar(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemCadastrado> salvar(@RequestBody @Valid Item item) {
        return new ResponseEntity<>(salvarItemPort.executar(item), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemCadastrado> alterar(@RequestBody @Valid ItemAlterar item, @PathVariable Long id) {
        return new ResponseEntity<>(alterarItemPort.executar(item, id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/categoria", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ItemCadastrado> alterarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        return new ResponseEntity<>(alterarItemCategoriaPort.executar(id, categoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        apagarItemPort.executar(id);
        return ResponseEntity.noContent().build();
    }
}
