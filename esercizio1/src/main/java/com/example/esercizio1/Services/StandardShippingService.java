package com.example.esercizio1.Services;

import org.springframework.stereotype.Service;

import com.example.esercizio1.Interfaces.IShippingService;

@Service
public class StandardShippingService implements IShippingService {
    public double calculateShipping(String country, double weight) {
        switch (country.toUpperCase()) {
            case "USA":
                return weight * 99; // we hate america
            case "EU":
                return weight * 3;
            case "ASIA":
                return weight * 33;
            default:
                return 0; // no shopping costs
        }
    }
}
