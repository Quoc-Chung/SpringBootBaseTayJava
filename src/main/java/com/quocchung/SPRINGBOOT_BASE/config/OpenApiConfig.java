package com.quocchung.SPRINGBOOT_BASE.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI(@Value("${openapi.service.title}") String title,
                               @Value("${openapi.service.version}") String version,
                               @Value("${openapi.service.description}") String description,
                               @Value("${openapi.service.serverUrl}") String serverUrl) {

    return new OpenAPI()
        .info(new Info()
            .title(title)
            .version(version)
            .description(description)
            .license(new License().name("API 2.0").url("https://github.com/quocchung")))
        .servers(List.of(
            new Server().url(serverUrl).description("SERVER TEST")
        ));
//        .components(new Components()
//            .addSecuritySchemes("bearerAuth", new SecurityScheme()
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("bearer")
//                .bearerFormat("JWT")
//            )
//        )
//        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
  }

  @Bean
  public GroupedOpenApi publicApi(@Value("${openapi.service.api-docs}") String apiDocs) {
    return GroupedOpenApi.builder()
        .group("api-service1")
        .packagesToScan("com.quocchung.SPRINGBOOT_BASE.controller")
        .build();
  }

}
