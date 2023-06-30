package com.tsswebapps.fiaplanches.configuration.springconfig.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ports.in.*;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.usecase.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItemBeans {

    @Bean
    public SalvarItemPort salvarItemPort(ItemRepository repository, CategoriaRepository categoriaRepository) {
        return new SalvarItemUseCase(repository, categoriaRepository);
    }

    @Bean
    public BuscarItemPorCodigoPort buscarItemPort(ItemRepository repository) {
        return new BuscarItemPorCodigoUseCase(repository);
    }
    @Bean
    public BuscarTodosItensPort buscarTodosItensPort(ItemRepository repository) {
        return new BuscarTodosItensUseCase(repository);
    }
    @Bean
    public ApagarItemPort apagarItemPort(ItemRepository repository) {
        return new ApagarItemUseCase(repository);
    }

    @Bean
    public AlterarItemPort alterarItemPort(ItemRepository repository) {
        return new AlterarItemUseCase(repository);
    }

    @Bean
    public AlterarItemCategoriaPort alterarItemCategoriaPort(ItemRepository repository, CategoriaRepository categoriaRepository) {
        return new AlterarItemCategoriaUseCase(repository, categoriaRepository);
    }

    @Bean
    public SalvarCategoriaPort salvarCategoriaPort(CategoriaRepository repository) {
        return new SalvarCategoriaUseCase(repository);
    }
    @Bean
    public BuscarTodasCategoriasPort buscarTodasCategoriasPort(CategoriaRepository repository) {
        return new BuscarTodasCategoriasUseCase(repository);
    }
    @Bean
    public BuscarCategoriaUseCasePort buscarCategoriaPort(CategoriaRepository repository) {
        return new BuscarCategoriaUseCasePort(repository);
    }
    @Bean
    public BuscarCategoriaPorDescricaoPort buscarCategoriaPorDescricaoPort(CategoriaRepository repository) {
        return new BuscarCategoriaPorDescricaoUseCase(repository);
    }
    @Bean
    public ApagarCategoriaPort apagarCategoriaPort(CategoriaRepository repository) {
        return new ApagarCategoriaUseCase(repository);
    }

}
