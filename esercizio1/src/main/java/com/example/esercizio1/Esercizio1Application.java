package com.example.esercizio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) // ✅ Correct way to exclude DB auto-config
public class Esercizio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Esercizio1Application.class, args);
    }

}
