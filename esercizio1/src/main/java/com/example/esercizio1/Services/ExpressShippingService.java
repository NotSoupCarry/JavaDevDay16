package com.example.esercizio1.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.esercizio1.Interfaces.IShippingService;

@Service
@Qualifier("expressShippingService")
public class ExpressShippingService implements IShippingService {
    public double calculateShipping(String country, double weight) {
        switch (country.toUpperCase()) {
            case "USA":
                return 25 + weight * 3; // we hate america
            case "EUROPE":
                return 30 + weight * 3.5;
            case "OTHER":
                return 40 + weight * 4;
            default:
                return 0; // no shopping costs error
        }
    }
}
