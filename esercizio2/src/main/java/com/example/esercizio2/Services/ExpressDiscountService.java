package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.esercizio2.Interfaces.IDiscountService;

@Service
@Qualifier("expressDiscountService")
public class ExpressDiscountService implements IDiscountService {
    @Override
    public double applyDiscount(double orderTotal) {
        if (orderTotal < 100) {
            return orderTotal; // Nessuno sconto
        } else if (orderTotal >= 100 && orderTotal < 200) {
            return orderTotal - (orderTotal * 0.07); // Sconto 7%
        } else {
            return orderTotal - (orderTotal * 0.12); // Sconto 12%
        }
    }
}
