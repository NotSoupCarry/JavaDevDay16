package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private final CalculatorService calculatorService;

    public TaxService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double applyTax(double amount, double taxRate) {
        return amount + calculatorService.multiply((int) amount, (int) taxRate);
    }

    public double calculateTotalWithFixedTax(double amount) {
        return applyTax(amount, 0.2);
    }
}
