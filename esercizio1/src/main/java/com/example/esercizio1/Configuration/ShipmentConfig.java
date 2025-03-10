package com.example.esercizio1.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.esercizio1.Interfaces.IShippingService;
import com.example.esercizio1.Services.CustomExpressShippingService;

@Configuration
public class ShipmentConfig {
    @Bean
    public IShippingService ExpresShippingService(){
        return new CustomExpressShippingService();
    }
}
