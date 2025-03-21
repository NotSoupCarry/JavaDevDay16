package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.esercizio2.Interfaces.IShippingService;

@Service
@Qualifier("standardShippingService")
@Primary
public class StandardShippingService implements IShippingService {
    public double calculateShippingCost(String country, double weight) {
        switch (country.toUpperCase()) {
            case "USA":
                return 10 + weight * 1.5;
            case "EUROPE":
                return 15 + weight * 2;
            case "OTHER":
                return 20 + weight * 2.5;
            default:
                return 0; // no shopping costs error
        }
    }
}
