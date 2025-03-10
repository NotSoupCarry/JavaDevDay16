package com.example.esercizio2.Services;

import org.springframework.stereotype.Service;
import com.example.esercizio2.Interfaces.IDiscountService;

@Service
public class CustomExpressDiscountService implements IDiscountService {
    @Override
    public double applyDiscount(double orderTotal) {
        if (orderTotal < 100) {
            return orderTotal; // Nessuno sconto
        } else if (orderTotal >= 100 && orderTotal < 200) {
            return orderTotal - (orderTotal * 0.40); // Sconto 40%
        } else {
            return orderTotal - (orderTotal * 0.80); // Sconto 80%
        }
    }
}
