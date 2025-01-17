package com.green.jwt.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
          title = "JWT"
        , description = "JWT Practice"
        , version = "v0.1"
    )
    , security = @SecurityRequirement(name = "Authorization")
)

@SecurityScheme(
          type = SecuritySchemeType.HTTP
        , name = "Authorization"
        , in = SecuritySchemeIn.HEADER
        , bearerFormat = "JWT"
        , scheme = "Bearer"
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfiguration {

    private final JwtConst jwtConst;

//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI().components(new Components()).info(new Info().title("dd"));
//    }


}
