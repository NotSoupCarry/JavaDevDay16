package com.example.test;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final DiscountService discountService;

    private OrderService(DiscountService discountService){
        this.discountService = discountService;
    }

    public double calculateFinalPrice(double amount){
        return discountService.applyDiscount(amount);
    }
}
