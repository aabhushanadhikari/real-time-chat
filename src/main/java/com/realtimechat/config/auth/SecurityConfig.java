package com.realtimechat.config.auth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing / Swagger
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/v1/message-controller/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()  // Allow API & Swagger without login
                        .anyRequest().authenticated() // Everything else requires auth
                );// Enable HTTP Basic auth for testing

        return http.build();
    }
}

