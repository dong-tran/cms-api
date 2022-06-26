package vn.mrku.cms.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI api() {
        SpringDocUtils.getConfig()
                .replaceWithClass(LocalTime.class, String.class);
        SpringDocUtils.getConfig()
                .replaceWithClass(LocalDateTime.class, String.class);
        return new OpenAPI();
    }

    OpenApiCustomiser apiKey() {
        return openApi -> openApi.components(new Components()
                        .addSecuritySchemes("APIKey", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")))
                .addSecurityItem(new SecurityRequirement().addList("APIKey"));
    }

    @Bean
    GroupedOpenApi authApi() {
        return GroupedOpenApi.builder().group("Auth")
                .pathsToMatch("/auth/**").build();
    }

    @Bean
    GroupedOpenApi openApi() {
        return GroupedOpenApi.builder().group("Open")
                .pathsToMatch("/open/**").build();
    }

    @Bean
    GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder().group("Admin")
                .pathsToMatch("/admin/**").addOpenApiCustomiser(apiKey()).build();
    }
}