package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) // ✅ Correct way to exclude DB auto-config
public class TaxServiceTest {

    @Autowired
    private TaxService taxService;

    @MockitoBean
    private CalculatorService calculatorService;

    @Test
    void testCalculateTotalWithFixedTax() {
        when(calculatorService.multiply(100, 0)).thenReturn(20.0); // Simuliamo il comportamento

        double result = taxService.calculateTotalWithFixedTax(100);
        assertEquals(120, result);

        verify(calculatorService, times(1)).multiply(100, 0); // Verifichiamo che sia stato chiamato
    }

    @Test
    void testCalculateTotalWithDifferentTax() {
        when(calculatorService.multiply(200, 0)).thenReturn(40.0);

        double result = taxService.applyTax(200, 0.2);
        assertEquals(240, result);
    }
}