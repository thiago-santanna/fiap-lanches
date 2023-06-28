package com.tsswebapps.fiaplanches.adapter.http.item;

import com.tsswebapps.fiaplanches.core.domain.Item.Categoria;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.ApagarCategoriaPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarCategoriaPorCodigoPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.BuscarTodasCategoriasPort;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.SalvarCategoriaPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final SalvarCategoriaPort salvarCategoriaPort;
    private final BuscarTodasCategoriasPort buscarTodasCategoriasPort;
    private final BuscarCategoriaPorCodigoPort buscarCategoriaPorCodigoPort;
    private final ApagarCategoriaPort apagarCategoriaPort;

    public CategoriaController(SalvarCategoriaPort salvarCategoriaPort, BuscarTodasCategoriasPort buscarTodasCategoriasPort, BuscarCategoriaPorCodigoPort buscarCategoriaPorCodigoPort, ApagarCategoriaPort apagarCategoriaPort) {
        this.salvarCategoriaPort = salvarCategoriaPort;
        this.buscarTodasCategoriasPort = buscarTodasCategoriasPort;
        this.buscarCategoriaPorCodigoPort = buscarCategoriaPorCodigoPort;
        this.apagarCategoriaPort = apagarCategoriaPort;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(salvarCategoriaPort.executar(categoria), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return new ResponseEntity(buscarTodasCategoriasPort.executar(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarcategoria(@PathVariable Long codigo) {
        return new ResponseEntity(buscarCategoriaPorCodigoPort.executar(codigo), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> apagar(@PathVariable Long codigo) {
        apagarCategoriaPort.executar(codigo);
        return ResponseEntity.noContent().build();
    }
}
