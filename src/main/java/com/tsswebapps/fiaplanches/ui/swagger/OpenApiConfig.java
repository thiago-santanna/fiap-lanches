package com.tsswebapps.fiaplanches.ui.swagger;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    public OpenAPI custonOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api de realização de pedido")
                        .description("Nesta API o usuário pode realizar pedidos de lanches de acordo com sua necessidade.")
                        .contact(new Contact()
                                .name("Thiago Sant' Anna da Silva")
                                .email("tss.webapps@gmail.com")
                                .url("https://www.linkedin.com/in/thiago-sant-anna-da-silva/"))
                        .version("1.0")
                );
    }
}
