package com.example.esercizio1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.esercizio1.Interfaces.IShippingService;
import com.example.esercizio1.Services.StandardShippingService;

@Configuration
public class AppConfig {

    // @Bean
    // public IShippingService iShippingService(){
    //     return new StandardShippingService(); // Cambia facilmente l'implementazione!
    // }
}
