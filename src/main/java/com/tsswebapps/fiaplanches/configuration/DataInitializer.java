package com.tsswebapps.fiaplanches.configuration;

import com.tsswebapps.fiaplanches.adapter.database.item.entity.CategoriaEntity;
import com.tsswebapps.fiaplanches.adapter.database.item.repository.CategoriaSpringDataJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoriaSpringDataJpaRepository categoriaSpringDataJpaRepository;

    public DataInitializer(CategoriaSpringDataJpaRepository categoriaSpringDataJpaRepository) {
        this.categoriaSpringDataJpaRepository = categoriaSpringDataJpaRepository;
    }

    private void init() {
        CategoriaEntity categoria01 = new CategoriaEntity();
        CategoriaEntity categoria02 = new CategoriaEntity();
        CategoriaEntity categoria03 = new CategoriaEntity();
        CategoriaEntity categoria04 = new CategoriaEntity();
        categoria01.setDescricao("Lanche");
        categoria02.setDescricao("Acompanhamento");
        categoria03.setDescricao("Bebida");
        categoria04.setDescricao("Sobremesa");
        List<CategoriaEntity> categoriaEntities = Arrays.asList(categoria01, categoria02, categoria03, categoria04);

        categoriaEntities.stream().forEach((CategoriaEntity entity) -> {
            var optionalCategoria = categoriaSpringDataJpaRepository.findByDescricao(entity.getDescricao());
            if (optionalCategoria.isEmpty()) {
                categoriaSpringDataJpaRepository.save(entity);
            }
        });
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }
}
