package com.app.staffsync_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("StaffSync API 🚀")
                        .version("1.0.0")
                        .description("Documentación oficial del microservicio de gestión de Empleados y Tareas.")
                );
    }
}
