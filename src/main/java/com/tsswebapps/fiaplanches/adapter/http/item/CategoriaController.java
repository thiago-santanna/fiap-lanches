package com.tsswebapps.fiaplanches.adapter.http.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return null;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarcategoria(@PathVariable Long codigo) {
        return null;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> apagar(@PathVariable Long codigo) {
        return null;
    }
}
