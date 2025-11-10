package com.realtimechat.config.auth;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI realTimeChatOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RealTime Chat API")
                        .description("Backend API documentation for RealTime Chat built with Spring Boot, RabbitMQ, and WebSocket.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
