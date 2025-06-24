package com.e_ticaret.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "E-Ticaret Backend API",
        version = "1.0.0",
        description = "Bu API, gönderilere etiket ekleme/çıkarma işlemleri yapar",
        termsOfService = "https://tahascode.com/"
    ),
    security = @SecurityRequirement(name = "BearerAuth")
)
@SecurityScheme(
    name = "BearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "JWT Bearer Token ile kimlik doğrulama için kullanılır. Lütfen Authorization başlığına " +
                  "Bearer <token> formatında token'ınızı ekleyin."
)
@Configuration
public class SwaggerConfig {
}