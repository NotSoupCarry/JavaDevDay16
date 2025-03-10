package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.esercizio2.Interfaces.IDiscountService;

@Service
@Qualifier("customExpressDiscountService")
public class CustomExpressDiscountService implements IDiscountService {
    public double applyDiscount(double orderTotal){
        if (orderTotal < 100) {
            return orderTotal * 5/100;
        }
        else if (orderTotal >= 100 && orderTotal <=200){
            return orderTotal * 40/100;
        }
        else{
            return orderTotal * 80/100;
        }
    }
}
