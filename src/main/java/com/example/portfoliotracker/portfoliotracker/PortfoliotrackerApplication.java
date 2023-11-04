package com.example.portfoliotracker.portfoliotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class PortfoliotrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfoliotrackerApplication.class, args);
    }

}
