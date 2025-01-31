package com.stock.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/**").permitAll()  // Permite todas las solicitudes a /api/*
                        .anyRequest().permitAll()  // Permite cualquier otra solicitud
                )
                .csrf(csrf -> csrf
                        .disable()  // Desactiva CSRF (solo si es necesario, en APIs REST generalmente se desactiva)
                );
        return http.build();  // Devuelve el filtro de seguridad configurado
    }
}