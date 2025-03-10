package com.example.demo;

public class TaxCalculator {
    private Calculator calculator = new Calculator(); // Still manual dependency

    public double applyTax(double amount, double taxRate) {
        return calculator.multiply(amount, taxRate) + amount;
    }

    public double calculateTotalWithFixedTax(double amount) {
        return applyTax(amount, 0.2); // Tassa fissa del 20%
    }
}
