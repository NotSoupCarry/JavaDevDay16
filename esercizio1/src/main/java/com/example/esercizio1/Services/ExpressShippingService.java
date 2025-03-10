package com.example.esercizio1.Services;

import org.springframework.stereotype.Service;

import com.example.esercizio1.Interfaces.IShippingService;

@Service
public class ExpressShippingService implements IShippingService{
    public double calculateShipping(String country, double weight) {
        if (weight >= 90.00){
            return weight * 80;
        }
        else if(weight < 90.00 && weight > 50.00){
            return weight * 50;
        }
        else if (weight <= 50.00 && weight > 20.00) {
            return weight * 20;
        }
        else{
            return weight;
        }
    }
}
