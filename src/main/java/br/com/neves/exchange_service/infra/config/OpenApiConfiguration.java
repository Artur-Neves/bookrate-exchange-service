package br.com.neves.exchange_service.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @Info(
        title = "Exchange Microsservice API",
        version = "v1",
        description = "Documentation of Exchange Microsservice API"))
public class OpenApiConfiguration {
    @Bean
    public OpenAPI cusOpenApi(){
        return new OpenAPI().components(new Components()).info(
                new io.swagger.v3.oas.models.info.Info()
                        .title("Exchange Microsservice API")
                        .version("V1")
                        .license(new License().name("MIT").url(""))
        );
    }
}
