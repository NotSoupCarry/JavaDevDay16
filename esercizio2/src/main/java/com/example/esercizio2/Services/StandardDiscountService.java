package com.example.esercizio2.Services;

import com.example.esercizio2.Interfaces.IDiscountService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("standardDiscountService")
@Primary
public class StandardDiscountService implements IDiscountService {
    public double applyDiscount(double orderTotal) {
        if (orderTotal < 100) {
            return orderTotal;
        } else if (orderTotal >= 100 && orderTotal <= 200) {
            return orderTotal * 5 / 100;
        } else {
            return orderTotal * 10 / 100;
        }
    }
}
