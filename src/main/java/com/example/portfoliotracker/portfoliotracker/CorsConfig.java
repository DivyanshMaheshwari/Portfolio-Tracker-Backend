package com.example.portfoliotracker.portfoliotracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/portfolio/**")
                        .allowedOrigins("http://localhost:3000") // Adjust the origin based on your React app URL
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}