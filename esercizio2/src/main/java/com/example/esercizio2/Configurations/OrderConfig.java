package com.example.esercizio2.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.esercizio2.Interfaces.IDiscountService;
import com.example.esercizio2.Services.CustomExpressDiscountService;

@Configuration
public class OrderConfig {
    @Bean
    public IDiscountService exprressDiscountService() {
        return new CustomExpressDiscountService();
    }
}
