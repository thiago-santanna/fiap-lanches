package com.tsswebapps.fiaplanches.application.springconfig.item;

import com.tsswebapps.fiaplanches.core.domain.Item.ports.out.ItemRepository;
import com.tsswebapps.fiaplanches.core.usecase.item.SalvarItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItemBeans {

    @Bean
    public SalvarItemUseCase salvarItemUseCase(ItemRepository repository) {
        return new SalvarItemUseCase(repository);
    }

}
