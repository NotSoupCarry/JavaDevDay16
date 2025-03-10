package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaxCalculatorTest {
    @Test
    void testCalculateTotalWithFixedTax() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double result = taxCalculator.calculateTotalWithFixedTax(100);
        System.out.println("|| Calculated total: " + result);
        assertEquals(120, result);
    }

}
