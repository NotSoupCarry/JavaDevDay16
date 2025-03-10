package com.example.test;

import org.springframework.stereotype.Service;

@Service
public class ProgressiveDiscountService implements DiscountService {
    @Override
    public double applyDiscount(double amount) {
        if (amount < 100) {
            return amount * 0.95;
        } else {
            return amount * 0.85;
        }
    }
}
