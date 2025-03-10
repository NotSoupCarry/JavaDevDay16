package com.example.esercizio1.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.esercizio1.Interfaces.IShippingService;

@Service
@Qualifier("customExpressShippingService")
public class CustomExpressShippingService implements IShippingService{
    public double calculateShipping(String country, double weight) {
        switch (country.toUpperCase()) {
            case "USA":
                return 20 + weight * 2.5;
            case "EUROPE":
                return 25 + weight * 3;
            case "OTHER":
                return 35 + weight * 3.5;
            default:
                return 0; // no shopping costs error
        }
    }
}
