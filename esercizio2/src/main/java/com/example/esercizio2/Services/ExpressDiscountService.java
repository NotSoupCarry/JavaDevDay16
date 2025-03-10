package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.esercizio2.Interfaces.IDiscountService;

@Service
@Qualifier("expressDiscountService")
public class ExpressDiscountService implements IDiscountService {
    public double applyDiscount(double orderTotal) {
        if (orderTotal < 100) {
            return orderTotal;
        } else if (orderTotal >= 100 && orderTotal <= 200) {
            return orderTotal * 7 / 100;
        } else {
            return orderTotal * 12 / 100;
        }
    }
}
