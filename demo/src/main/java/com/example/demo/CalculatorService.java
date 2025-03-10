package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}
