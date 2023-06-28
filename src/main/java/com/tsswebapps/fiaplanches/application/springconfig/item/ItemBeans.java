package com.tsswebapps.fiaplanches.application.springconfig.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.CategoriaRepository;
import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.usecase.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItemBeans {

    @Bean
    public SalvarItemUseCase salvarItemUseCase(ItemRepository repository) {
        return new SalvarItemUseCase(repository);
    }
    @Bean
    public BuscarItemPorCodigoUseCase buscarItemUseCase(ItemRepository repository) {
        return new BuscarItemPorCodigoUseCase(repository);
    }
    @Bean
    public AlterarItemUseCase alterarItemUseCase(ItemRepository repository) {
        return new AlterarItemUseCase(repository);
    }
    @Bean
    public SalvarCategoriaUseCase salvarCategoriaPort(CategoriaRepository repository) {
        return new SalvarCategoriaUseCase(repository);
    }
    @Bean
    public BuscarTodasCategoriasPortUseCase buscarTodasCategoriasUseCase(CategoriaRepository repository) {
        return new BuscarTodasCategoriasPortUseCase(repository);
    }
    @Bean
    public BuscarCategoriaUseCasePort buscarCategoriaUseCase(CategoriaRepository repository) {
        return new BuscarCategoriaUseCasePort(repository);
    }
    @Bean ApagarCategoriaUseCase apagarCategoriaUseCase(CategoriaRepository repository) {
        return new ApagarCategoriaUseCase(repository);
    }

}
