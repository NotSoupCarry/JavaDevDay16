package com.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DiscountService discountService() {
        return new ProgressiveDiscountService(); // Cambia facilmente l'implementazione!
    }
}
